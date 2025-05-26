package com.app.roles.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "roles")
@Data
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true, unique = true)
    private String name;

    @Column(nullable = true)  
    private String typeOperator;

    // Empty constructor (required for JPA)
    public Rol() {}

    // Constructor with parameters
    public Rol(Long id, String name, String typeOperator) {
        this.id = id;
        this.name = name;
        this.typeOperator = typeOperator;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTypeOperator() {
        return typeOperator;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTypeOperator(String typeOperator) {
        this.typeOperator = typeOperator;
    }
}