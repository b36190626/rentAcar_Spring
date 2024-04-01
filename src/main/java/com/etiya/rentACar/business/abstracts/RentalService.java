package com.etiya.rentacar.business.abstracts;




import com.etiya.rentacar.business.dtos.requests.rental.CreateRentalRequest;
import com.etiya.rentacar.business.dtos.requests.rental.UpdateRentalRequest;
import com.etiya.rentacar.business.dtos.responses.rental.CreatedRentalResponse;
import com.etiya.rentacar.business.dtos.responses.rental.DeletedRentalResponse;
import com.etiya.rentacar.business.dtos.responses.rental.GetListRentalResponse;
import com.etiya.rentacar.business.dtos.responses.rental.UpdatedRentalResponse;

import java.util.List;
public interface RentalService {

    CreatedRentalResponse getById(int id);
    List<GetListRentalResponse> getAll();
    CreatedRentalResponse add(CreateRentalRequest createRentalRequest);
    UpdatedRentalResponse update(UpdateRentalRequest updateRentalRequest);
    DeletedRentalResponse delete(int id);
}
