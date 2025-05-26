package com.app.typevehicles.domain;

import java.util.List;

public interface ITypeVehicleService {
    
    List<TypeVehicle> findAll();

    TypeVehicle findById(Long id);

    TypeVehicle save(TypeVehicle typevehicle);

    TypeVehicle update(TypeVehicle typevehicle, Long id);

    void deleteById(Long id);
}
