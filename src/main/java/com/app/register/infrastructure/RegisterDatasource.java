package com.app.register.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.app.register.domain.IRegisterRepository;
import com.app.register.domain.Register;

@Component
public class RegisterDatasource {

    private final IRegisterRepository registerRepository;

    public RegisterDatasource(IRegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }


    public List<Register> findAll() {
        return registerRepository.findAll();
    }

  
    public Optional<Register> findById(Long id) {
        return registerRepository.findById(id);
    }

 
    public Register save(Register register) {
        return registerRepository.save(register);
    }


   public Optional<Register> update(Register register, Long id) {
    return registerRepository.findById(id).map(existingRegister -> {
        existingRegister.setVehicle(register.getVehicle());
        existingRegister.setServices(register.getServices());
        existingRegister.setUser(register.getUser());
        existingRegister.setRegisterDate(register.getRegisterDate());
        return registerRepository.save(existingRegister);
    });
}

   
    public boolean deleteById(Long id) {
        if (registerRepository.existsById(id)) {
            registerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
