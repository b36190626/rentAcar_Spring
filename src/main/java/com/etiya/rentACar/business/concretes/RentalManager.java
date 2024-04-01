package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.CarService;
import com.etiya.rentacar.business.abstracts.RentalService;
import com.etiya.rentacar.business.dtos.requests.rental.CreateRentalRequest;
import com.etiya.rentacar.business.dtos.requests.rental.UpdateRentalRequest;
import com.etiya.rentacar.business.dtos.responses.car.GetCarListResponse;
import com.etiya.rentacar.business.dtos.responses.car.GetCarResponse;
import com.etiya.rentacar.business.dtos.responses.rental.CreatedRentalResponse;
import com.etiya.rentacar.business.dtos.responses.rental.DeletedRentalResponse;
import com.etiya.rentacar.business.dtos.responses.rental.GetListRentalResponse;
import com.etiya.rentacar.business.dtos.responses.rental.UpdatedRentalResponse;
import com.etiya.rentacar.core.exceptions.types.BusinessException;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataAccess.abstracts.RentalRepository;
import com.etiya.rentacar.entities.Car;
import com.etiya.rentacar.entities.Customer;
import com.etiya.rentacar.entities.Rental;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RentalManager implements RentalService {
    private RentalRepository rentalRepository;
    private CarService carService;
    private ModelMapperService modelMapperService;

    @Override
    public UpdatedRentalResponse update(UpdateRentalRequest updateRentalRequest) {
        return null;
    }

    @Override
    public DeletedRentalResponse delete(int id) {
        return null;
    }

    private void checkIfCarState(int carId) {
        GetCarResponse getCarResponse = carService.getById(carId);
        if(getCarResponse.getState()==2)
            throw new BusinessException("This vehicle has been rented before. Rental status is -not available-");//TODO BUSINESS EXC

    }
    @Override
    public CreatedRentalResponse getById(int id) {
        return null;
    }

    @Override
    public List<GetListRentalResponse> getAll() {
        List<Rental> cities = rentalRepository.findAll();
        return cities.stream().filter(city -> city.getDeletedDate() == null)
                .map(city -> modelMapperService.forResponse()
                        .map(city, GetListRentalResponse.class)).collect(Collectors.toList());
    }

    @Override
    public CreatedRentalResponse add(CreateRentalRequest createRentalRequest) {//TODO GLOBAL BUSINESS EXCEPTIONS
        checkIfCarState(createRentalRequest.getCarId());
        GetCarResponse getCarResponse = carService.getById(createRentalRequest.getCarId());
        Car car = new Car();
        car.setId(createRentalRequest.getCarId());

        Customer customer = new Customer();
        customer.setId(createRentalRequest.getCustomerId());

        Rental mappedRental = new Rental();
        mappedRental.setRentStartDate(createRentalRequest.getRentStartDate());
        mappedRental.setRentEndDate(createRentalRequest.getRentEndDate());
        mappedRental.setRentedKilometer(car.getKilometer());
        mappedRental.setCar(car);
        mappedRental.setCustomer(customer);

        Rental createdRental = rentalRepository.save(mappedRental);
        carService.updateCarState(createRentalRequest.getCarId(),2);
        CreatedRentalResponse createdRentalResponse = modelMapperService.forResponse().map(createdRental,CreatedRentalResponse.class);
        return createdRentalResponse;

        //Rental mappedRental  = modelMapperService.forRequest().map(createRentalRequest, Rental.class);
        //mappedRental.setRentedKilometer(getCarResponse.);
    }
}
