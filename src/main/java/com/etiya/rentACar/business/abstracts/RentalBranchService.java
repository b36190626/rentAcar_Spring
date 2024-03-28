package com.etiya.rentacar.business.abstracts;

import com.etiya.rentacar.business.dtos.requests.city.CreateCityRequest;
import com.etiya.rentacar.business.dtos.requests.city.UpdateCityRequest;
import com.etiya.rentacar.business.dtos.requests.rentalBranch.CreateRentalBranchRequest;
import com.etiya.rentacar.business.dtos.requests.rentalBranch.UpdateRentalBranchRequest;
import com.etiya.rentacar.business.dtos.responses.city.CreatedCityResponse;
import com.etiya.rentacar.business.dtos.responses.city.DeletedCityResponse;
import com.etiya.rentacar.business.dtos.responses.city.GetListCityResponse;
import com.etiya.rentacar.business.dtos.responses.city.UpdatedCityResponse;
import com.etiya.rentacar.business.dtos.responses.rentalBranch.CreatedRentalBranchResponse;
import com.etiya.rentacar.business.dtos.responses.rentalBranch.DeletedRentalBranchResponse;
import com.etiya.rentacar.business.dtos.responses.rentalBranch.GetListRentalBranchesResponse;
import com.etiya.rentacar.business.dtos.responses.rentalBranch.UpdatedRentalBranchResponse;

import java.util.List;

public interface RentalBranchService {

    CreatedRentalBranchResponse getById(int id);
    List<GetListRentalBranchesResponse> getAll();
    CreatedRentalBranchResponse add(CreateRentalBranchRequest createRentalBranchRequest);
    UpdatedRentalBranchResponse update(UpdateRentalBranchRequest updateRentalBranchRequest);
    DeletedRentalBranchResponse delete(int id);
}
