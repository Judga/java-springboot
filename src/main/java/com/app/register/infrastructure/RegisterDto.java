package com.app.register.infrastructure;

public class RegisterDto {
    private Long id;
    private String vehicle;
    private String service;
    private String serviceState;
    private String operator;
    private String email;

    // Empty constructor
    public RegisterDto() {
    }

    // Constructor with parameters
    public RegisterDto(Long id, String vehicle, String service, String serviceState, String operator, String email) {
        this.id = id;
        this.vehicle = vehicle;
        this.service = service;
        this.serviceState = serviceState;
        this.operator = operator;
        this.email = email;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getServiceState() {
        return serviceState;
    }

    public void setServiceState(String serviceState) {
        this.serviceState = serviceState;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // toString() method
    @Override
    public String toString() {
        return "RegisterDto{" +
                "id=" + id +
                ", vehicle='" + vehicle + '\'' +
                ", service='" + service + '\'' +
                ", serviceState='" + serviceState + '\'' +
                ", operator='" + operator + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
