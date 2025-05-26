package com.app.services.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceRepository extends JpaRepository<CarService, Long> {

    // Get all service (already provided by JpaRepository)
    @Override
    @NonNull
    List<CarService> findAll();

    // Search service by ID (already provided by JpaRepository)
    @Override
    @NonNull
    Optional<CarService> findById(@NonNull Long id);

    // Save a service (already provided by JpaRepository)
    @Override
    @NonNull
    <S extends CarService> S save(@NonNull S service);

    // Check if a service with a specific ID exists (already provided by
    // JpaRepository)
    @Override
    boolean existsById(@NonNull Long id);

    // Delete service by ID (already provided by JpaRepository)
    @Override
    void deleteById(@NonNull Long id);
}
