package com.etiya.rentACar.business.abstracts;

import com.etiya.rentACar.business.dtos.requests.CreateBrandRequest;
import com.etiya.rentACar.business.dtos.responses.CreatedBrandResponse;
import com.etiya.rentACar.business.dtos.responses.GetAllBrandsResponse;


import java.util.List;

public interface BrandService {
    CreatedBrandResponse add(CreateBrandRequest brand);
    List<GetAllBrandsResponse> getAll();
}
