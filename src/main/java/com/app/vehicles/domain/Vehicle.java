package com.app.vehicles.domain;

import com.app.brands.domain.Brand;
import com.app.typevehicles.domain.TypeVehicle;
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

    @ManyToOne
    @JoinColumn(name = "type_vehicle_id", nullable = false)
    private TypeVehicle typeVehicle;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @Column(nullable = false)
    private String color;

    // Empty constructor (required for JPA)
    public Vehicle() {}

    // Constructor with parameters
    public Vehicle(Long id, String plate, TypeVehicle typeVehicle, Brand brand, String color) {
        this.id = id;
        this.plate = plate;
        this.typeVehicle = typeVehicle; 
        this.brand = brand;
        this.color = color;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public String getPlate() {
        return plate;
    }

    public TypeVehicle getTypeVehicle() {
        return typeVehicle;
    }

    public Brand getBrand() {
        return brand;
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

    public void setTypeVehicle(TypeVehicle typeVehicle) {
        this.typeVehicle = typeVehicle;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
    }
}