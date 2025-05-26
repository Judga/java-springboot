package com.app.vehicles.infrastructure;

public class VehicleDto {
    private Long id;
    private String plate;
    private String typeVehicleId;
    private String brandId;
    private String color;

    // Empty constructor
    public VehicleDto() {
    }

    // Constructor with parameters
    public VehicleDto(Long id, String plate, String typeVehicleId, String brandId, String color) {
        this.id = id;
        this.plate = plate;
        this.typeVehicleId = typeVehicleId;
        this.brandId = brandId;
        this.color = color;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getTypeVehicleId() {
        return typeVehicleId;
    }

    public void setTypeVehicleId(String typeVehicleId) {
        this.typeVehicleId = typeVehicleId;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // toString() method
    @Override
    public String toString() {
        return "VehicleDto{" +
                "id=" + id +
                ", plate='" + plate + '\'' +
                ", typeVehicleId='" + typeVehicleId + '\'' +
                ", brandId='" + brandId + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}