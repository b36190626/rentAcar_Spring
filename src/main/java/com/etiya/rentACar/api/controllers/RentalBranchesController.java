package com.etiya.rentacar.api.controllers;

import com.etiya.rentacar.business.abstracts.RentalBranchService;
import com.etiya.rentacar.business.dtos.requests.city.UpdateCityRequest;
import com.etiya.rentacar.business.dtos.requests.fuel.CreateFuelRequest;
import com.etiya.rentacar.business.dtos.requests.model.CreateModelRequest;
import com.etiya.rentacar.business.dtos.requests.rentalBranch.CreateRentalBranchRequest;
import com.etiya.rentacar.business.dtos.requests.rentalBranch.UpdateRentalBranchRequest;
import com.etiya.rentacar.business.dtos.responses.city.CreatedCityResponse;
import com.etiya.rentacar.business.dtos.responses.city.DeletedCityResponse;
import com.etiya.rentacar.business.dtos.responses.city.UpdatedCityResponse;
import com.etiya.rentacar.business.dtos.responses.fuel.CreatedFuelResponse;
import com.etiya.rentacar.business.dtos.responses.model.CreatedModelResponse;
import com.etiya.rentacar.business.dtos.responses.model.GetModelListResponse;
import com.etiya.rentacar.business.dtos.responses.model.GetModelResponse;
import com.etiya.rentacar.business.dtos.responses.rental.CreatedRentalResponse;
import com.etiya.rentacar.business.dtos.responses.rentalBranch.CreatedRentalBranchResponse;
import com.etiya.rentacar.business.dtos.responses.rentalBranch.DeletedRentalBranchResponse;
import com.etiya.rentacar.business.dtos.responses.rentalBranch.GetListRentalBranchesResponse;
import com.etiya.rentacar.business.dtos.responses.rentalBranch.UpdatedRentalBranchResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rentalBranches")
@AllArgsConstructor
public class RentalBranchesController {
    private RentalBranchService rentalBranchService;

    @GetMapping
    public List<GetListRentalBranchesResponse> getAll(){
        return rentalBranchService.getAll();
    }

    @GetMapping("/{id}")
    public CreatedRentalBranchResponse getById(@PathVariable int id){
        return rentalBranchService.getById(id);
    }

    public CreatedRentalBranchResponse add(@RequestBody CreateRentalBranchRequest createRentalBranchRequest){
        return rentalBranchService.add(createRentalBranchRequest);
    }
    @PutMapping
    public UpdatedRentalBranchResponse update(@Valid @RequestBody UpdateRentalBranchRequest updateRentalBranchRequest) {
        return rentalBranchService.update(updateRentalBranchRequest);
    }

    @DeleteMapping("/{id}")
    public DeletedRentalBranchResponse delete(@PathVariable int id) {
        return rentalBranchService.delete(id);
    }

}
