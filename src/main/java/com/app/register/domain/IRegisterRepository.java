package com.app.register.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface IRegisterRepository extends JpaRepository<Register, Long> {

    @Override
    @NonNull
    List<Register> findAll();

    @Override
    @NonNull
    Optional<Register> findById(@NonNull Long id);

    @Override
    @NonNull
    <S extends Register> S save(@NonNull S register);

    @Override
    boolean existsById(@NonNull Long id);

    @Override
    void deleteById(@NonNull Long id);

    Optional<Register> findByEmail(String email);

    boolean existsByEmail(String email);
}