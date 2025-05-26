package com.app.roles.adapters;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.roles.domain.IRolService;
import com.app.roles.domain.Rol;

@RestController
@RequestMapping("/api/users")
public class RolController {

    private final IRolService rolService;

    public RolController(IRolService rolService) {
        this.rolService = rolService;
    }

    // all users
    @GetMapping
    public ResponseEntity<List<Rol>> getAllRoles() {
        List<Rol> roles = rolService.findAll();
        return ResponseEntity.ok(roles);
    }

    // user by id
    @GetMapping("/{id}")
    public ResponseEntity<Rol> getRolById(@PathVariable Long id) {
        Rol rol = rolService.findById(id);
        return ResponseEntity.ok(rol);
    }

    // create user
    @PostMapping
    public ResponseEntity<Rol> createRol(@RequestBody Rol rol) {
        Rol newRol = rolService.save(rol);
        return ResponseEntity.ok(newRol);
    }

    // update user
    @PutMapping("/{id}")
    public ResponseEntity<Rol> updateRol(@PathVariable Long id, @RequestBody Rol rol) {
        Rol updatedRol = rolService.update(rol, id);
        return ResponseEntity.ok(updatedRol);
    }

    // delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        rolService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
