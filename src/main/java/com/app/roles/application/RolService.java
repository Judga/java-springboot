package com.app.roles.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.shared.adapters.exception.ResourceNotFoundException;

import com.app.roles.domain.IRolRepository;
import com.app.roles.domain.IRolService;
import com.app.roles.domain.Rol;

@Service
public class RolService implements IRolService {

    private final IRolRepository rolRepository;

    public RolService(IRolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public List<Rol> findAll() {
        return rolRepository.findAll();
    }

    @Override
    public Rol findById(Long id) {
        return rolRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not found with ID: " + id));
    }

    @Override
    @Transactional
    public Rol save(Rol rol) {
        if (rolRepository.existsByTypeOperator(rol.getTypeOperator())) {
            throw new IllegalArgumentException("type operator registred: " + rol.getTypeOperator());
        }
        return rolRepository.save(rol);
    }

    @Override
    @Transactional
    public Rol update(Rol rol, Long id) {
        Rol existingRol = findById(id);
        existingRol.setName(rol.getName());
        existingRol.setTypeOperator(rol.getTypeOperator());
        return rolRepository.save(existingRol);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Rol rol = findById(id);
        rolRepository.delete(rol);
    }
}
