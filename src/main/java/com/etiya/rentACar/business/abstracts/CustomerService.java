package com.etiya.rentacar.business.abstracts;

import com.etiya.rentacar.business.dtos.requests.customer.CreateCustomerRequest;
import com.etiya.rentacar.business.dtos.requests.customer.UpdateCustomerRequest;
import com.etiya.rentacar.business.dtos.responses.customer.CreatedCustomerResponse;
import com.etiya.rentacar.business.dtos.responses.customer.DeletedCustomerResponse;
import com.etiya.rentacar.business.dtos.responses.customer.GetListCustomerResponse;
import com.etiya.rentacar.business.dtos.responses.customer.UpdatedCustomerResponse;

import java.util.List;

public interface CustomerService {
    CreatedCustomerResponse getById(int id);
    List<GetListCustomerResponse> getAll();
    CreatedCustomerResponse add(CreateCustomerRequest createCityRequest);
    UpdatedCustomerResponse update(UpdateCustomerRequest updateCityRequest);
    DeletedCustomerResponse delete(int id);
}
