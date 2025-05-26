package com.app.brands.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.shared.adapters.exception.ResourceNotFoundException;

import com.app.brands.domain.IBrandRepository;
import com.app.brands.domain.IBrandService;
import com.app.brands.domain.Brand;

@Service
public class BrandService implements IBrandService {

    private final IBrandRepository brandRepository;

    public BrandService(IBrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand findById(Long id) {
        return brandRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("brand not found with ID: " + id));
    }

    @Override
    @Transactional
    public Brand save(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    @Transactional
    public Brand update(Brand brand, Long id) {
        Brand existingBrand = findById(id);
        existingBrand.setName(brand.getName());
        return brandRepository.save(existingBrand);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Brand brand = findById(id);
        brandRepository.delete(brand);
    }
}