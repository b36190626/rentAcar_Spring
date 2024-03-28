package com.etiya.rentacar.entities;

import com.etiya.rentacar.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="rental_branches")
public class RentalBranch extends BaseEntity {
    private String name;

    @ManyToOne
    @JoinColumn(name = "cityId")
    private City city;

    @OneToMany(mappedBy = "rentalBranch")
    private List<Car> cars;

    @OneToMany(mappedBy = "rentalBranch")
    private List<Rental> rentals;
}
