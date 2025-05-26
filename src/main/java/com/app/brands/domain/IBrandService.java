package com.app.brands.domain;

import java.util.List;

public interface IBrandService {
    
    List<Brand> findAll();

    Brand findById(Long id);

    Brand save(Brand Brand);

    Brand update(Brand Brand, Long id);

    void deleteById(Long id);
}
