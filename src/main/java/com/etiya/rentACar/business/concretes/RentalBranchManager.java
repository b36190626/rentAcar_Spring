package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.RentalBranchService;
import com.etiya.rentacar.business.dtos.requests.rentalBranch.CreateRentalBranchRequest;
import com.etiya.rentacar.business.dtos.requests.rentalBranch.UpdateRentalBranchRequest;
import com.etiya.rentacar.business.dtos.responses.rentalBranch.CreatedRentalBranchResponse;
import com.etiya.rentacar.business.dtos.responses.rentalBranch.DeletedRentalBranchResponse;
import com.etiya.rentacar.business.dtos.responses.rentalBranch.GetListRentalBranchesResponse;
import com.etiya.rentacar.business.dtos.responses.rentalBranch.UpdatedRentalBranchResponse;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataAccess.abstracts.RentalBranchRepository;
import com.etiya.rentacar.entities.RentalBranch;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RentalBranchManager implements RentalBranchService {
    private RentalBranchRepository rentalBranchRepository;
    private ModelMapperService modelMapperService;
    @Override
    public CreatedRentalBranchResponse getById(int id) {
        return null;
    }

    @Override
    public List<GetListRentalBranchesResponse> getAll() {
        return null;
    }

    @Override
    public CreatedRentalBranchResponse add(CreateRentalBranchRequest createRentalBranchRequest) {
        RentalBranch mappedRentalBranch = modelMapperService.forRequest().map(createRentalBranchRequest, RentalBranch.class);
        RentalBranch createdRentalBranch = rentalBranchRepository.save(mappedRentalBranch);
        CreatedRentalBranchResponse createdRentalBranchResponse = modelMapperService.forResponse().map(createdRentalBranch,CreatedRentalBranchResponse.class);
        return createdRentalBranchResponse;
    }

    @Override
    public UpdatedRentalBranchResponse update(UpdateRentalBranchRequest updateRentalBranchRequest) {
        return null;
    }

    @Override
    public DeletedRentalBranchResponse delete(int id) {
        return null;
    }
}
