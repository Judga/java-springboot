package com.app.typevehicles.adapters;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.typevehicles.domain.ITypeVehicleService;
import com.app.typevehicles.domain.TypeVehicle;

@RestController
@RequestMapping("/api/typevehicles")
public class TypeVehicleController {

    private final ITypeVehicleService typeVehiclesService;

    public TypeVehicleController(ITypeVehicleService typeVehiclesService) {
        this.typeVehiclesService = typeVehiclesService;
    }

    // all typeVehicle
    @GetMapping
    public ResponseEntity<List<TypeVehicle>> getAllUsers() {
        List<TypeVehicle> typeVehicle = typeVehiclesService.findAll();
        return ResponseEntity.ok(typeVehicle);
    }

    // user by id
    @GetMapping("/{id}")
    public ResponseEntity<TypeVehicle> getUserById(@PathVariable Long id) {
        TypeVehicle typeVehicle = typeVehiclesService.findById(id);
        return ResponseEntity.ok(typeVehicle);
    }

    // create user
    @PostMapping
    public ResponseEntity<TypeVehicle> createUser(@RequestBody TypeVehicle typeVehicle) {
        TypeVehicle newUser = typeVehiclesService.save(typeVehicle);
        return ResponseEntity.ok(newUser);
    }

    // update user
    @PutMapping("/{id}")
    public ResponseEntity<TypeVehicle> updateTypeVehicle(@PathVariable Long id, @RequestBody TypeVehicle typeVehicle) {
        TypeVehicle updatedTypeVehicle = typeVehiclesService.update(typeVehicle, id);
        return ResponseEntity.ok(updatedTypeVehicle);
    }

    // delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        typeVehiclesService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
