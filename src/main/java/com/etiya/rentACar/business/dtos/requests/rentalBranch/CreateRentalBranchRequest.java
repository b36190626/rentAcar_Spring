package com.etiya.rentacar.business.dtos.requests.rentalBranch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRentalBranchRequest {
    private String name;
    private int cityId;
}
