package com.app.vehicles.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, Long> {

    // Get all users (already provided by JpaRepository)
    @Override
    @NonNull
    List<Vehicle> findAll();

    // Search user by ID (already provided by JpaRepository)
    @Override
    @NonNull
    Optional<Vehicle> findById(@NonNull Long id);

    // Save a user (already provided by JpaRepository)
    @Override
    @NonNull
    <S extends Vehicle> S save(@NonNull S vehicle);

    // Check if a user with a specific ID exists (already provided by JpaRepository)
    @Override
    boolean existsById(@NonNull Long id);

    // Delete user by ID (already provided by JpaRepository)
    @Override
    void deleteById(@NonNull Long id);

    // Additional application-specific methods:

    Optional<Vehicle> findByPlate(String plate);

    // Check if an email is already registered
    boolean existsByPlate(String plate);

    // Search for a user by their email
    Optional<Vehicle> findByTypevehiculo(int typeVehicleId);

    // Check if an email is already registered
    boolean existsByTypevehiculo(String typeVehicleId);

    Optional<Vehicle> findByBrandid(String brandId);

    // Check if an email is already registered
    boolean existsByBrandid(String brandId);

    Optional<Vehicle> findByColor(String color);

    // Check if an email is already registered
    boolean existsByColor(String color);

}