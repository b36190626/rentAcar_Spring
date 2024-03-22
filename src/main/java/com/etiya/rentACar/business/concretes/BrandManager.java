package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.BrandService;
import com.etiya.rentACar.business.dtos.requests.CreateBrandRequest;
import com.etiya.rentACar.business.dtos.responses.CreatedBrandResponse;
import com.etiya.rentACar.business.dtos.responses.GetAllBrandsResponse;
import com.etiya.rentACar.dataAccess.abstracts.BrandRepository;
import com.etiya.rentACar.entities.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service

public class BrandManager implements BrandService {
    private BrandRepository brandRepository;

    @Override
    public CreatedBrandResponse add(CreateBrandRequest createBrandRequest) {
        //todo : Business rules

        //mapping
        Brand brand = new Brand();
        brand.setName(createBrandRequest.getName());
        brand.setCreatedDate(LocalDateTime.now());

        Brand createdBrand =   this.brandRepository.save(brand);

        //mapping
        CreatedBrandResponse createdBrandResponse = new CreatedBrandResponse();
        createdBrandResponse.setId(createdBrand.getId());
        createdBrandResponse.setName(createdBrand.getName());
        createdBrandResponse.setCreatedDate(createdBrand.getCreatedDate());

        return createdBrandResponse;
    }
    @Override
    public List<GetAllBrandsResponse> getAll(){
        List<Brand> brands = brandRepository.findAll();
        List<GetAllBrandsResponse> brandsResponse = new ArrayList<GetAllBrandsResponse>();
        for (Brand brand : brands){
        GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
        responseItem.setId(brand.getId());
        }
        return brandsResponse;
    }
}
//Tüm entityler için Add,Update,Delete, GetAll,GetById operasyonlarını uçtan uca yazınız.
//tamamında response-request pattern uygulanmalı

//@Service, @Component, @Bean, @Repository anotasyonlarını detaylı araştırınız.IoC