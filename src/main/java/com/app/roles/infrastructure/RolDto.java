package com.app.roles.infrastructure;

public class RolDto {
    private Long id;
    private String name;
    private String typeOperator;

    // Empty constructor
    public RolDto() {
    }

    // Constructor with parameters
    public RolDto(Long id, String name, String typeOperator) {
        this.id = id;
        this.name = name;
        this.typeOperator = typeOperator;
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

    public String getTypeOperator() {
        return typeOperator;
    }

    public void setTypeOperator(String typeOperator) {
        this.typeOperator = typeOperator;
    }

    // toString() method
    @Override
    public String toString() {
        return "RolDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typeOperator='" + typeOperator + '\'' +
                '}';
    }
}