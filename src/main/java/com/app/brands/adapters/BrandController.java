package com.app.brands.adapters;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.brands.domain.IBrandService;
import com.app.brands.domain.Brand;

@RestController
@RequestMapping("/api/users")
public class BrandController {

    private final IBrandService brandService;

    public BrandController(IBrandService brandService) {
        this.brandService = brandService;
    }

    // all users
    @GetMapping
    public ResponseEntity<List<Brand>> getAllBrands() {
        List<Brand> brands = brandService.findAll();
        return ResponseEntity.ok(brands);
    }

    // user by id
    @GetMapping("/{id}")
    public ResponseEntity<Brand> getBrandrById(@PathVariable Long id) {
        Brand brand =brandService.findById(id);
        return ResponseEntity.ok(brand);
    }

    // create user
    @PostMapping
    public ResponseEntity<Brand> createBrand(@RequestBody Brand brand) {
        Brand newBrand = brandService.save(brand);
        return ResponseEntity.ok(newBrand);
    }

    // update user
    @PutMapping("/{id}")
    public ResponseEntity<Brand> updateBrand(@PathVariable Long id, @RequestBody Brand brand) {
        Brand updatedBrand = brandService.update(brand, id);
        return ResponseEntity.ok(updatedBrand);
    }

    // delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable Long id) {
        brandService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
