package com.app.typevehicles.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.shared.adapters.exception.ResourceNotFoundException;

import com.app.typevehicles.domain.ITypeVehicleRepository;
import com.app.typevehicles.domain.ITypeVehicleService;
import com.app.typevehicles.domain.TypeVehicle;

@Service
public class TypeVehicleService implements ITypeVehicleService {

    private final ITypeVehicleRepository typeVehicleRepository;

    public TypeVehicleService(ITypeVehicleRepository typeVehicleRepository) {
        this.typeVehicleRepository = typeVehicleRepository;
    }

    @Override
    public List<TypeVehicle> findAll() {
        return typeVehicleRepository.findAll();
    }

    @Override
    public TypeVehicle findById(Long id) {
        return typeVehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("typeVehicle not found with ID: " + id));
    }

    @Override
    @Transactional
    public TypeVehicle save(TypeVehicle typevehicle) {
        return typeVehicleRepository.save(typevehicle);
    }

    @Override
    @Transactional
    public TypeVehicle update(TypeVehicle typevehicle, Long id) {
        TypeVehicle existingTypeVehicle = findById(id);
        existingTypeVehicle.setName(typevehicle.getName());
        return typeVehicleRepository.save(existingTypeVehicle);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        TypeVehicle typeVehicle = findById(id);
        typeVehicleRepository.delete(typeVehicle);
    }
}
