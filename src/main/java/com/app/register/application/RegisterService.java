package com.app.register.application;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.shared.adapters.exception.ResourceNotFoundException;
import com.app.register.domain.IRegisterRepository;
import com.app.register.domain.IRegisterService;
import com.app.register.domain.Register;

@Service
public class RegisterService implements IRegisterService {

    private final IRegisterRepository registerRepository;

    public RegisterService(IRegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    @Override
    public List<Register> findAll() {
        return registerRepository.findAll();
    }

    @Override
    public Register findById(Long id) {
        return registerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Register not found with ID: " + id));
    }

    @Override
    @Transactional
    public Register save(Register register) {
        validateRegister(register);
        return registerRepository.save(register);
    }

    @Override
    @Transactional
    public Register update(Register register, Long id) {
        Register existingRegister = findById(id);
        BeanUtils.copyProperties(register, existingRegister, "id");
        validateRegister(existingRegister);
        return registerRepository.save(existingRegister);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if (!registerRepository.existsById(id)) {
            throw new ResourceNotFoundException("Register not found with ID: " + id);
        }
        registerRepository.deleteById(id);
    }

    private void validateRegister(Register register) {
        if (register.getUser() == null) {
            throw new IllegalArgumentException("User ID must be greater than 0");
        }
        if (register.getVehicle() == null) {
            throw new IllegalArgumentException("Vehicle ID must be greater than 0");
        }
        if (register.getServices() == null) {
            throw new IllegalArgumentException("Service ID must be greater than 0");
        }
    }
}