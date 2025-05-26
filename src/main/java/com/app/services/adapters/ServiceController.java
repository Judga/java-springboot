package com.app.services.adapters;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.services.domain.IServiceService;
import com.app.services.domain.CarService;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    private final IServiceService serviceService;

    public ServiceController(IServiceService serviceService) {
        this.serviceService = serviceService;
    }

    // all carService
    @GetMapping
    public ResponseEntity<List<CarService>> getAllCarServicess() {
        List<CarService> carService = serviceService.findAll();
        return ResponseEntity.ok(carService);
    }

    // carService by id
    @GetMapping("/{id}")
    public ResponseEntity<CarService> getCarServicesById(@PathVariable Long id) {
        CarService carService = serviceService.findById(id);
        return ResponseEntity.ok(carService);
    }

    // create carService
    @PostMapping
    public ResponseEntity<CarService> createCarServices(@RequestBody CarService carService) {
        CarService newCarService = serviceService.save(carService);
        return ResponseEntity.ok(newCarService);
    }

    // update carService
    @PutMapping("/{id}")
    public ResponseEntity<CarService> updateCarServices(@PathVariable Long id, @RequestBody CarService carService) {
        CarService updatedCarService = serviceService.update(carService, id);
        return ResponseEntity.ok(updatedCarService);
    }

    // delete carService
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarServices(@PathVariable Long id) {
        serviceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
