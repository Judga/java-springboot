package com.app.typevehicles.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.app.typevehicles.domain.ITypeVehicleRepository;
import com.app.typevehicles.domain.TypeVehicle;

@Component
public class TypeVehicleDatasource {

    private final ITypeVehicleRepository typeVehicleRepository;

    public TypeVehicleDatasource(ITypeVehicleRepository typeVehicleRepository) {
        this.typeVehicleRepository = typeVehicleRepository;
    }

    public List<TypeVehicle> findAll() {
        return typeVehicleRepository.findAll();
    }
    public Optional<TypeVehicle> findById(Long id) {
        return typeVehicleRepository.findById(id);
    }

    public TypeVehicle save(TypeVehicle typeVehicle) {
        return typeVehicleRepository.save(typeVehicle);
    }

    public Optional<TypeVehicle> update(TypeVehicle typeVehicle, Long id) {
        return typeVehicleRepository.findById(id).map(existingUser -> {
            existingUser.setName(typeVehicle.getName());
            return typeVehicleRepository.save(existingUser);
        });
    }

    public boolean deleteById(Long id) {
        if (typeVehicleRepository.existsById(id)) {
            typeVehicleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
