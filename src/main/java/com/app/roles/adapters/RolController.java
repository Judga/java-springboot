package com.app.roles.adapters;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.roles.domain.IRolService;
import com.app.roles.domain.Rol;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    private final IRolService rolService;

    public RolController(IRolService rolService) {
        this.rolService = rolService;
    }

    // Get all roles
    @GetMapping
    public ResponseEntity<List<Rol>> getAllRoles() {
        List<Rol> roles = rolService.findAll();
        return ResponseEntity.ok(roles);
    }

    // Get role by id
    @GetMapping("/{id}")
    public ResponseEntity<Rol> getRolById(@PathVariable Long id) {
        Rol rol = rolService.findById(id);
        return ResponseEntity.ok(rol);
    }

    // Create new role
    @PostMapping
    public ResponseEntity<Rol> createRol(@RequestBody Rol rol) {
        Rol newRol = rolService.save(rol);
        return ResponseEntity.ok(newRol);
    }

    // Update existing role
    @PutMapping("/{id}")
    public ResponseEntity<Rol> updateRol(@PathVariable Long id, @RequestBody Rol rol) {
        Rol updatedRol = rolService.update(rol, id);
        return ResponseEntity.ok(updatedRol);
    }

    // Delete role
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRol(@PathVariable Long id) {
        rolService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
