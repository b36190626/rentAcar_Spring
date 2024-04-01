package com.etiya.rentacar.entities;

import com.etiya.rentacar.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="rentals")
public class Rental extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "carId",nullable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @Column(name = "rentStartDate")
    private LocalDateTime rentStartDate;

    @Column(name = "rentEndDate")
    private LocalDateTime rentEndDate;

    @Column(name = "returnDate")
    private LocalDateTime returnDate;

    @Column(name = "rentedKilometer")
    private int rentedKilometer;

    @Column(name = "returnedKilometer")
    private int returnedKilometer;


//    @ManyToOne
//    @JoinColumn(name = "rentalBranchId")
//    private RentalBranch rentalBranch;

}