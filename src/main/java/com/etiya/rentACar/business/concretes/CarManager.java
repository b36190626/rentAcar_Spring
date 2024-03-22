package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.BrandService;
import com.etiya.rentACar.business.abstracts.CarService;
import com.etiya.rentACar.business.dtos.requests.CreateBrandRequest;
import com.etiya.rentACar.business.dtos.requests.CreateCarRequest;
import com.etiya.rentACar.business.dtos.responses.CreatedBrandResponse;
import com.etiya.rentACar.business.dtos.responses.GetAllBrandsResponse;
import com.etiya.rentACar.business.dtos.responses.cars.CreatedCarResponse;
import com.etiya.rentACar.business.dtos.responses.cars.GetAllCarsResponse;
import com.etiya.rentACar.dataAccess.abstracts.BrandRepository;
import com.etiya.rentACar.dataAccess.abstracts.CarRepository;
import com.etiya.rentACar.entities.Car;
import com.etiya.rentACar.entities.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service

public class CarManager implements CarService {
    private CarRepository carRepository;


    @Override
    public CreatedCarResponse add(CreateCarRequest carRequest) {
        Car car = new Car();
        Model model = new Model();
        model.setId(carRequest.getModelId());
        car.setModelYear(carRequest.getModelYear());
        car.setDailyPrice(carRequest.getDailyPrice());
        car.setPlate(carRequest.getPlate());
        car.setState(carRequest.getState());
        car.setModel(model);
        var createdCar = carRepository.save(car);
        CreatedCarResponse createdCarResponse = new CreatedCarResponse();
        createdCarResponse.setModelYear(createdCar.getModelYear());
        createdCarResponse.setPlate(createdCar.getPlate());
        createdCarResponse.setDailyPrice(createdCar.getDailyPrice());
        createdCarResponse.setState(createdCar.getState());
        createdCarResponse.setModelId(createdCar.getModel().getId());

        return createdCarResponse;
    }

    @Override
    public List<GetAllCarsResponse> getAll() {
        return null;
    }
}
//Tüm entityler için Add,Update,Delete, GetAll,GetById operasyonlarını uçtan uca yazınız.
//tamamında response-request pattern uygulanmalı

//@Service, @Component, @Bean, @Repository anotasyonlarını detaylı araştırınız.IoC