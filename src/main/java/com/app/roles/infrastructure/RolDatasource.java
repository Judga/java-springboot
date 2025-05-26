package com.app.roles.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.app.roles.domain.IRolRepository;
import com.app.roles.domain.Rol;

@Component
public class RolDatasource {

    private final IRolRepository rolRepository;

    public RolDatasource(IRolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    public List<Rol> findAll() {
        return rolRepository.findAll();
    }
    public Optional<Rol> findById(Long id) {
        return rolRepository.findById(id);
    }

    public Rol save(Rol rol) {
        return rolRepository.save(rol);
    }

    public Optional<Rol> update(Rol rol, Long id) {
    return rolRepository.findById(id).map(existingRol -> {
        existingRol.setName(rol.getName());
        existingRol.setTypeOperator(rol.getTypeOperator());
        return rolRepository.save(existingRol);
    });
    }

    public boolean deleteById(Long id) {
        if (rolRepository.existsById(id)) {
            rolRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
