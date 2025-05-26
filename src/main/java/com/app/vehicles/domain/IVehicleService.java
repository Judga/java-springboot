package com.app.vehicles.domain;

import java.util.List;

public interface IVehicleService {
    
    List<Vehicle> findAll();

    Vehicle findById(Long id);

    Vehicle save(Vehicle Vehicle);

    Vehicle update(Vehicle Vehicle, Long id);

    void deleteById(Long id);
}
