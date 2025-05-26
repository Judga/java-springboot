package com.app.brands.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;


@Repository
public interface IBrandRepository extends JpaRepository<Brand, Long> {

    // Get all users (already provided by JpaRepository)
    @Override
    @NonNull
    List<Brand> findAll();

    // Search user by ID (already provided by JpaRepository)
    @Override
    @NonNull
    Optional<Brand> findById(@NonNull Long id);

    // Save a user (already provided by JpaRepository)
    @Override
    @NonNull
    <S extends Brand> S save(@NonNull S brand);

    // Check if a user with a specific ID exists (already provided by JpaRepository)
    @Override
    boolean existsById(@NonNull Long id);

    // Delete user by ID (already provided by JpaRepository)
    @Override
    void deleteById(@NonNull Long id);

    // Additional application-specific methods:
    /* 
    // Search for a user by their email
    Optional<Brand> findByName(String name);

    // Check if an email is already registered
    boolean existsByName(String name);  */

}