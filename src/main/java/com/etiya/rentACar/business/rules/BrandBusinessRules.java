package com.etiya.rentacar.business.rules;

import com.etiya.rentacar.dataAccess.abstracts.BrandRepository;
import com.etiya.rentacar.entities.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service // injection ve referans oluşumu için
@AllArgsConstructor
public class BrandBusinessRules {
    BrandRepository brandRepository;

    public void brandNameCannotBeDuplicated(String brandName) {
        Optional<Brand> brand = brandRepository.findByNameIgnoreCase(brandName);

        if (brand.isPresent()) {
            throw new RuntimeException("Brand Exists");
        }
    }

    public void brandIdIsExist(int id) {
        Optional<Brand> brand = brandRepository.findById(id);
        if (brand.isEmpty()) {
            throw new RuntimeException("Fuel Id Is Not Exists...");
        }
    }

}
