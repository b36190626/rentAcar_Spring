package com.etiya.rentACar.business.abstracts;

import com.etiya.rentACar.business.dtos.requests.CreateCarRequest;
import com.etiya.rentACar.business.dtos.responses.cars.CreatedCarResponse;
import com.etiya.rentACar.business.dtos.responses.cars.GetAllCarsResponse;

import java.util.List;

public interface CarService {
    CreatedCarResponse add(CreateCarRequest carRequest);
    List<GetAllCarsResponse> getAll();
}
