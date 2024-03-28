package com.etiya.rentacar.dataAccess.abstracts;

import com.etiya.rentacar.entities.Fuel;
import com.etiya.rentacar.entities.Transmission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransmissionRepository extends JpaRepository<Transmission, Integer> {
    Optional<Fuel> findByNameIgnoreCase(String brandName);
}
