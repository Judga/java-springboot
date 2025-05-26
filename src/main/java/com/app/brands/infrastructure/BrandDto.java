package com.app.brands.infrastructure;

public class BrandDto {
    private Long id;
    private String name;

    // Empty constructor
    public BrandDto() {
    }

    // Constructor with parameters
    public BrandDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and Setters
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

    // toString() method
    @Override
    public String toString() {
        return "BrandDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}