package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.CustomerService;
import com.etiya.rentacar.business.dtos.requests.customer.CreateCustomerRequest;
import com.etiya.rentacar.business.dtos.requests.customer.UpdateCustomerRequest;
import com.etiya.rentacar.business.dtos.responses.customer.CreatedCustomerResponse;
import com.etiya.rentacar.business.dtos.responses.customer.DeletedCustomerResponse;
import com.etiya.rentacar.business.dtos.responses.customer.GetListCustomerResponse;
import com.etiya.rentacar.business.dtos.responses.customer.UpdatedCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    @Override
    public CreatedCustomerResponse getById(int id) {
        return null;
    }

    @Override
    public List<GetListCustomerResponse> getAll() {
        return null;
    }

    @Override
    public CreatedCustomerResponse add(CreateCustomerRequest createCityRequest) {
        return null;
    }

    @Override
    public UpdatedCustomerResponse update(UpdateCustomerRequest updateCityRequest) {
        return null;
    }

    @Override
    public DeletedCustomerResponse delete(int id) {
        return null;
    }
}
