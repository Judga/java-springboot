package com.app.services.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.shared.adapters.exception.ResourceNotFoundException;

import com.app.services.domain.IServiceRepository;
import com.app.services.domain.IServiceService;
import com.app.services.domain.CarService;

@Service
public class CarServices implements IServiceService {

    private final IServiceRepository serviceRepository;

    public CarServices(IServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public List<CarService> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public CarService findById(Long id) {
        return serviceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("service not found with ID: " + id));
    }

    @Override
    @Transactional
    public CarService save(CarService service) {
        return serviceRepository.save(service);
    }

    @Override
    @Transactional
    public CarService update(CarService service, Long id) {
        CarService existingService = findById(id);
        existingService.setName(service.getName());
        existingService.setdescription(service.getdescription());
        existingService.setprice(service.getprice());
        return serviceRepository.save(existingService);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        CarService service = findById(id);
        serviceRepository.delete(service);
    }
}
