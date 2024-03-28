package com.etiya.rentacar.business.rules;

import com.etiya.rentacar.dataAccess.abstracts.FuelRepository;
import com.etiya.rentacar.dataAccess.abstracts.TransmissionRepository;
import com.etiya.rentacar.entities.Car;
import com.etiya.rentacar.entities.Fuel;
import com.etiya.rentacar.entities.Transmission;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TransmissionBusinessRules {

    private TransmissionRepository transmissionRepository;

    public void transmissionNameCannotBeDuplicated(String brandName) {
        Optional<Fuel> fuel = transmissionRepository.findByNameIgnoreCase(brandName);
        if (fuel.isPresent()) {
            throw new RuntimeException("Brand Exists...");
        }
    }

    public void transmissionIdIsExist(int id) {
        Optional<Transmission> transmission = transmissionRepository.findById(id);
        if (transmission.isEmpty()) {
            throw new RuntimeException("Fuel Id Is Not Exists...");
        }
    }
}