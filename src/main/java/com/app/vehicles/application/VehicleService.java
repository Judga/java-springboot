package com.app.vehicles.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.shared.adapters.exception.ResourceNotFoundException;

import com.app.vehicles.domain.IVehicleRepository;
import com.app.vehicles.domain.IVehicleService;
import com.app.vehicles.domain.Vehicle;

@Service
public class VehicleService implements IVehicleService {

    private final IVehicleRepository vehicleRepository;

    public VehicleService(IVehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle findById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not found with ID: " + id));
    }

    @Override
    @Transactional
    public Vehicle save(Vehicle vehicle) {
        if (vehicleRepository.existsByPlate(vehicle.getPlate())) {
            throw new IllegalArgumentException("Plate registred: " + vehicle.getPlate());
        }
        if (vehicleRepository.existsByTypevehiculo(vehicle.getTypeVehicleId())) {
            throw new IllegalArgumentException("Type registred: " + vehicle.getTypeVehicleId());
        }
        if (vehicleRepository.existsByBrandid(vehicle.getBrandId())) {
            throw new IllegalArgumentException("Brand id registred: " + vehicle.getBrandId());
        }
        if (vehicleRepository.existsByColor(vehicle.getColor())) {
            throw new IllegalArgumentException("Color registred: " + vehicle.getColor());
        }
        return vehicleRepository.save(vehicle);
    }


    @Override
    @Transactional
    public Vehicle update(Vehicle vehicle, Long id) {
        Vehicle existingVehicle = findById(id);
        existingVehicle.setPlate(vehicle.getPlate());
        existingVehicle.setTypeVehicleId(vehicle.getTypeVehicleId());
        existingVehicle.setBrandId(vehicle.getBrandId());
        existingVehicle.setColor(vehicle.getColor());
        return vehicleRepository.save(existingVehicle);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Vehicle vehicle = findById(id);
        vehicleRepository.delete(vehicle);
    }
}
