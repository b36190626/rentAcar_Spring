package com.etiya.rentacar.api.controllers;

import com.etiya.rentacar.business.abstracts.CityService;
import com.etiya.rentacar.business.dtos.requests.city.CreateCityRequest;
import com.etiya.rentacar.business.dtos.requests.city.UpdateCityRequest;
import com.etiya.rentacar.business.dtos.responses.city.CreatedCityResponse;
import com.etiya.rentacar.business.dtos.responses.city.DeletedCityResponse;
import com.etiya.rentacar.business.dtos.responses.city.GetListCityResponse;
import com.etiya.rentacar.business.dtos.responses.city.UpdatedCityResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/cities")
public class CitiesController {
    private CityService cityService;

    @GetMapping("/{id}")
    public CreatedCityResponse findById(@PathVariable int id) {
        return cityService.getById(id);
    }

    @GetMapping
    public List<GetListCityResponse> findAll() {
        return cityService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCityResponse save(@Valid @RequestBody CreateCityRequest createCityRequest) {
        return cityService.add(createCityRequest);
    }

    @PutMapping
    public UpdatedCityResponse update(@Valid @RequestBody UpdateCityRequest updateCityRequest) {
        return cityService.update(updateCityRequest);
    }

    @DeleteMapping("/{id}")
    public DeletedCityResponse delete(@PathVariable int id) {
        return cityService.delete(id);
    }
}
