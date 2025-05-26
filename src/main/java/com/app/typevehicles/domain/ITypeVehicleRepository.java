package com.app.typevehicles.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypeVehicleRepository extends JpaRepository<TypeVehicle, Long> {

    // Get all TypeVehicles (already provided by JpaRepository)
    @Override
    @NonNull
    List<TypeVehicle> findAll();

    // Search typeVehicle by ID (already provided by JpaRepository)
    @Override
    @NonNull
    Optional<TypeVehicle> findById(@NonNull Long id);

    // Save a typeVehicle (already provided by JpaRepository)
    @Override
    @NonNull
    <S extends TypeVehicle> S save(@NonNull S typeVehicle);

    // Check if a typeVehicle with a specific ID exists (already provided by JpaRepository)
    @Override
    boolean existsById(@NonNull Long id);

    // Delete typeVehicle by ID (already provided by JpaRepository)
    @Override
    void deleteById(@NonNull Long id);

}
