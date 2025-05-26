package com.app.services.domain;

import java.util.List;

public interface IServiceService {
    
    List<CarService> findAll();

    CarService findById(Long id);

    CarService save(CarService service);

    CarService update(CarService service, Long id);

    void deleteById(Long id);
}
