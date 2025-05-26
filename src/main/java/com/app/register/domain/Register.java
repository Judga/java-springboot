package com.app.register.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "registers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    @NotNull(message = "user cannot be null")
    private int userId; 

    @Column(name = "vehicle_id", nullable = false)
    @NotNull(message = "Vehicle cannot be null")
    private int vehicleId; 

    @Column(name = "service_id", nullable = false)
    @NotNull(message = "Service cannot be null")
    private int serviceId; 

    @Column(name = "service_state_id", nullable = false)
    @NotNull(message = "ServiceState cannot be null")
    private int serviceStateId; 

    @Column(name = "operator_id", nullable = false)
    @NotNull(message = "Operator cannot be null")
    private int operatorId; 

    @Column(name = "email", nullable = false, unique = true)
    @NotNull(message = "Email cannot be null")
    private String email;

    @Column(name = "register_date", nullable = false)
    @NotNull(message = "Date cannot be null")
    @Temporal(TemporalType.TIMESTAMP) 
    private Date registerDate; 
}