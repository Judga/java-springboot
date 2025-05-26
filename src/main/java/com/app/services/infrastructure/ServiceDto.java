package com.app.services.infrastructure;

public class ServiceDto {
    private Long id;
    private String name;
    private Double price;
    private String description;

    // Empty constructor
    public ServiceDto() {
    }

    // Constructor with parameters
    public ServiceDto(Long id, String name, Double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getprice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getdescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // toString() method
    @Override
    public String toString() {
        return "ServiceDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                "description" + description + '\'' +
                '}';
    }
}
