package com.app.services.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.app.services.domain.IServiceRepository;
import com.app.services.domain.CarService;

@Component
public class ServiceDatasource {

    private final IServiceRepository serviceRepository;

    public ServiceDatasource(IServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<CarService> findAll() {
        return serviceRepository.findAll();
    }

    public Optional<CarService> findById(Long id) {
        return serviceRepository.findById(id);
    }

    public CarService save(CarService carService) {
        return serviceRepository.save(carService);
    }

    public Optional<CarService> update(CarService carService, Long id) {
        return serviceRepository.findById(id).map(existingUser -> {
            existingUser.setName(carService.getName());
            existingUser.setprice(carService.getprice());
            existingUser.setdescription(carService.getdescription());
            return serviceRepository.save(existingUser);
        });
    }

    public boolean deleteById(Long id) {
        if (serviceRepository.existsById(id)) {
            serviceRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
