package com.app.vehicles.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.app.vehicles.domain.IVehicleRepository;
import com.app.vehicles.domain.Vehicle;

@Component
public class VehicleDatasource {

    private final IVehicleRepository vehicleRepository;

    public VehicleDatasource(IVehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }
    public Optional<Vehicle> findById(Long id) {
        return vehicleRepository.findById(id);
    }

    public Vehicle save(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public Optional<Vehicle> update(Vehicle vehicle, Long id) {
        return vehicleRepository.findById(id).map(existingVehicle -> {
            existingVehicle.setPlate(vehicle.getPlate());
            existingVehicle.setTypeVehicleId(vehicle.getTypeVehicleId());
            existingVehicle.setBrandId(vehicle.getBrandId());
            existingVehicle.setColor(vehicle.getColor());
            return vehicleRepository.save(existingVehicle);
        });
    }

    public boolean deleteById(Long id) {
        if (vehicleRepository.existsById(id)) {
            vehicleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
