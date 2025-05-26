package com.app.brands.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.app.brands.domain.Brand;
import com.app.brands.domain.IBrandRepository;

@Component
public class BrandDatasource {

    private final IBrandRepository brandRepository;

    public BrandDatasource(IBrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<Brand> findAll() {
        return brandRepository.findAll();
    }
    public Optional<Brand> findById(Long id) {
        return brandRepository.findById(id);
    }

    public Brand save(Brand brand){
        return brandRepository.save(brand);
    }

    public Optional<Brand> update(Brand brand, Long id) {
    return brandRepository.findById(id).map(existingBrand -> {
        existingBrand.setName(brand.getName());
        return brandRepository.save(existingBrand);
    });
    }

    public boolean deleteById(Long id) {
        if (brandRepository.existsById(id)) {
            brandRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
