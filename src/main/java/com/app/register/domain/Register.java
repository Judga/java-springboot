package com.app.register.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

import java.util.List;

import com.app.users.domain.User;
import com.app.vehicles.domain.Vehicle;
import com.app.services.domain.CarService;

@Entity
@Table(name = "registers")
@Data
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull(message = "user cannot be null")
    private User user;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    @NotNull(message = "Vehicle cannot be null")
    private Vehicle vehicle;

    @ManyToMany
    @JoinTable(name = "services_id", joinColumns = @JoinColumn(name = "register_id"), inverseJoinColumns = @JoinColumn(name = "service_id"))
    @NotNull(message = "Services cannot be null")
    private List<CarService> services;

    @Column(name = "email", nullable = false, unique = true)
    @NotNull(message = "Email cannot be null")
    private String email;

    @Column(name = "register_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date registerDate;

    public Register() {
        this.registerDate = new Date();

    }

    public Register(Long id, User user, Vehicle vehicle, List<CarService> services, String email, Date registerDate) {
        this.id = id;
        this.user = user;
        this.vehicle = vehicle;
        this.services = services;
        this.email = email;
        this.registerDate = new Date();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public List<CarService> getServices() {
        return this.services;
    }

    public void setServices(List<CarService> services) {
        this.services = services;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegisterDate() {
        return this.registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
}
