package com.etiya.rentacar.business.abstracts;

import com.etiya.rentacar.business.dtos.requests.city.CreateCityRequest;
import com.etiya.rentacar.business.dtos.requests.city.UpdateCityRequest;
import com.etiya.rentacar.business.dtos.responses.city.CreatedCityResponse;
import com.etiya.rentacar.business.dtos.responses.city.DeletedCityResponse;
import com.etiya.rentacar.business.dtos.responses.city.GetListCityResponse;
import com.etiya.rentacar.business.dtos.responses.city.UpdatedCityResponse;

import java.util.List;

public interface CityService {
    CreatedCityResponse getById(int id);
    List<GetListCityResponse> getAll();
    CreatedCityResponse add(CreateCityRequest createCityRequest);
    UpdatedCityResponse update(UpdateCityRequest updateCityRequest);
    DeletedCityResponse delete(int id);
}
