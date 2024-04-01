package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.CarService;
import com.etiya.rentacar.business.abstracts.ModelService;
import com.etiya.rentacar.business.dtos.requests.car.CreateCarRequest;
import com.etiya.rentacar.business.dtos.requests.car.UpdateCarRequest;
import com.etiya.rentacar.business.dtos.responses.brand.GetBrandListResponse;
import com.etiya.rentacar.business.dtos.responses.car.CreatedCarResponse;
import com.etiya.rentacar.business.dtos.responses.car.GetCarListResponse;
import com.etiya.rentacar.business.dtos.responses.car.GetCarResponse;
import com.etiya.rentacar.business.dtos.responses.car.UpdatedCarResponse;
import com.etiya.rentacar.business.rules.CarBusinessRules;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataAccess.abstracts.CarRepository;
import com.etiya.rentacar.entities.Brand;
import com.etiya.rentacar.entities.Car;
import com.etiya.rentacar.entities.CarStatus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarManager implements CarService {

    private final CarRepository carRepository;
    private ModelMapperService modelMapperService;
    private CarBusinessRules carBusinessRules;

    @Override
    public CreatedCarResponse add(CreateCarRequest createCarRequest) {
        Car car = modelMapperService.forRequest().map(createCarRequest, Car.class);
        car.setCreatedDate(LocalDateTime.now());
        Car savedCar = carRepository.save(car);
        return modelMapperService.forResponse().map(savedCar, CreatedCarResponse.class);

    }

    @Override
    public UpdatedCarResponse update(UpdateCarRequest updateCarRequest) {
        Car updatedCar = modelMapperService.forRequest().map(updateCarRequest, Car.class);
        updatedCar.setUpdatedDate(LocalDateTime.now());
        Car savedCar = carRepository.save(updatedCar);
        return modelMapperService.forResponse().map(savedCar, UpdatedCarResponse.class);
    }

    @Override
    public List<GetCarListResponse> getAll() {
        List<Car> cars = carRepository.findAll();
        return cars.stream().filter(car -> car.getDeletedDate() == null)
                .map(car -> modelMapperService.forResponse()
                        .map(car, GetCarListResponse.class)).collect(Collectors.toList());
    }

    @Override
    public GetCarResponse getById(int id) {
        Car car = findById(id);
        return modelMapperService.forResponse().map(car, GetCarResponse.class);
    }


    @Override
    public void delete(int id) {
        Car car = findById(id);
        car.setDeletedDate(LocalDateTime.now());
        carRepository.save(car);

    }

    @Override
    public void updateCarState(int carId, int state) {
        Car car = carRepository.findById(carId).get();
        car.setState(state);
        carRepository.save(car);
    }

    private Car findById(int id) {
        carBusinessRules.carIdIsExist(id);
        return carRepository.findById(id).get();
    }
//TODO
//    private Car updateCarState(int carId, int State) {
//        Car car
//    }

//    public void rentCar() {
//        if (car == CarStatus.AVAILABLE.getValue()) {
//            this.status = CarStatus.RENTED.getValue();
//        } else {
//            throw new IllegalStateException("Car is not available for rent.");
//        }
//    }
//
//    public void returnCar(int endKilometer) {
//        if (this.status == CarStatus.RENTED.getValue()) {
//            this.endKilometer = endKilometer;
//            int kilometersDriven = this.endKilometer - this.startKilometer;
//
//            // this.currentKilometer += kilometersDriven;
//            this.status = CarStatus.AVAILABLE.getValue();
//        } else {
//            throw new IllegalStateException("Car is not rented.");
//        }
//    }
//
//    public void setUnderMaintenance() {
//        this.status = CarStatus.UNDER_MAINTENANCE.getValue();
//    }

// --------Service and Business Rules--------

//    public void changeCar(Car oldCar, Car newCar) {
//        if (oldCar.getStatus() == CarStatus.RENTED) {
//            throw new IllegalStateException("Old car is currently rented and cannot be changed.");
//        }
//        oldCar.setStatus(CarStatus.AVAILABLE);
//        newCar.setStatus(CarStatus.RENTED);
//}
//
//    public void reportUnderMaintenance(Car car) {
//        car.setUnderMaintenance();
//    }
}
