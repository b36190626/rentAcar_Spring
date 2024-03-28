package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.CityService;
import com.etiya.rentacar.business.dtos.requests.city.CreateCityRequest;
import com.etiya.rentacar.business.dtos.requests.city.UpdateCityRequest;
import com.etiya.rentacar.business.dtos.responses.car.UpdatedCarResponse;
import com.etiya.rentacar.business.dtos.responses.city.CreatedCityResponse;
import com.etiya.rentacar.business.dtos.responses.city.DeletedCityResponse;
import com.etiya.rentacar.business.dtos.responses.city.GetListCityResponse;
import com.etiya.rentacar.business.dtos.responses.city.UpdatedCityResponse;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataAccess.abstracts.CityRepository;
import com.etiya.rentacar.entities.Car;
import com.etiya.rentacar.entities.City;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CityManager implements CityService {
    private CityRepository cityRepository;
    private ModelMapperService modelMapperService;
    @Override
    public CreatedCityResponse getById(int id) {
        City city =findById(id);
        return modelMapperService.forResponse().map(city,CreatedCityResponse.class);
    }

    @Override
    public List<GetListCityResponse> getAll() {
        List<City> cities = cityRepository.findAll();
        return cities.stream().filter(city -> city.getDeletedDate() == null)
                .map(city -> modelMapperService.forResponse()
                        .map(city, GetListCityResponse.class)).collect(Collectors.toList());
    }

    @Override
    public CreatedCityResponse add(CreateCityRequest createCityRequest) {
        City mappedCity = modelMapperService.forRequest().map(createCityRequest, City.class);
        City createdCity = cityRepository.save(mappedCity);
        return modelMapperService.forResponse().map(createdCity, CreatedCityResponse.class);
    }

    @Override
    public UpdatedCityResponse update(UpdateCityRequest updateCityRequest) {
        City city = findById(updateCityRequest.getId());
        City mappedCity = modelMapperService.forRequest().map(updateCityRequest, City.class);
        mappedCity.setCreatedDate(city.getCreatedDate());
        City savedCity = cityRepository.save(mappedCity);
        return modelMapperService.forResponse().map(savedCity, UpdatedCityResponse.class);
    }

    @Override
    public DeletedCityResponse delete(int id) {
        City city = findById(id);
        city.setDeletedDate(LocalDateTime.now());
        cityRepository.save(city);
        return modelMapperService.forResponse().map(city, DeletedCityResponse.class);
    }
    private City findById(int id) {
        return cityRepository.findById(id).get();
    }
}
