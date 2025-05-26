package com.app.roles.domain;

import java.util.List;

public interface IRolService {
    
    List<Rol> findAll();

    Rol findById(Long id);

    Rol save(Rol Rol);

    Rol update(Rol Rol, Long id);

    void deleteById(Long id);
}
