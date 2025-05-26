package com.app.register.domain;

import java.util.List;

public interface IRegisterService {

    List<Register> findAll();

    Register findById(Long id);

    Register save(Register register);

    Register update(Register register, Long id);

    void deleteById(Long id);
}
