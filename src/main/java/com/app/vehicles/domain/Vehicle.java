package com.app.vehicles.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "vehicles")
@Data
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String plate;

    @Column(nullable = false)
    private String typeVehicleId;

    @Column(nullable = false)
    private String brandId;

    @Column(nullable = false, unique = true)
    private String color;

    // Empty constructor (required for JPA)
    public Vehicle() {}

    // Constructor with parameters
    public Vehicle(Long id, String plate,String typeVehicleId, String brandId, String color) {
        this.id = id;
        this.plate = plate;
        this.typeVehicleId = typeVehicleId; 
        this.brandId = brandId;
        this.color = color;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public String getPlate() {
        return plate;
    }

    public String getTypeVehicleId() {
        return typeVehicleId;
    }

    public String getBrandId() {
        return brandId;
    }

    public String getColor() {
        return color;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public void setTypeVehicleId(String typeVehicleId) {
        this.typeVehicleId = typeVehicleId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public void setColor(String color) {
        this.color = color;
    }
}