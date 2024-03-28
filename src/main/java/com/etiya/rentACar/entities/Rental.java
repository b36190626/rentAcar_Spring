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
    @Column(name = "rentDate")
    private LocalDateTime rentDate;
    @Column(name = "returnedDate")
    private LocalDateTime returnDate;
    @Column(name = "rentedKilometer")
    private int rentedKilometer;
    @Column(name = "returnedKilometer")
    private int returnedKilometer;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "carId")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "rentalBranchId")
    private RentalBranch rentalBranch;

}
