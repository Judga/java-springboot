package com.app.register.adapters;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.register.domain.IRegisterService;
import com.app.register.domain.Register;

@RestController
@RequestMapping("/api/registers")
public class RegisterController {

    private final IRegisterService registerService;

    public RegisterController(IRegisterService registerService) {
        this.registerService = registerService;
    }

    // Get all registers
    @GetMapping
    public ResponseEntity<List<Register>> getAllRegisters() {
        List<Register> registers = registerService.findAll();
        return ResponseEntity.ok(registers);
    }

    // Get register by ID
    @GetMapping("/{id}")
    public ResponseEntity<Register> getRegisterById(@PathVariable Long id) {
        Register register = registerService.findById(id);
        return ResponseEntity.ok(register);
    }

    // Create a new register
    @PostMapping
    public ResponseEntity<Register> createRegister(@RequestBody Register register) {
        Register newRegister = registerService.save(register);
        return ResponseEntity.ok(newRegister);
    }

    // Update a register
    @PutMapping("/{id}")
    public ResponseEntity<Register> updateRegister(@PathVariable Long id, @RequestBody Register register) {
        Register updatedRegister = registerService.update(register, id);
        return ResponseEntity.ok(updatedRegister);
    }

    // Delete a register
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegister(@PathVariable Long id) {
        registerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}