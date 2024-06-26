package com.etiya.rentacar.business.dtos.responses.rentalBranch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListRentalBranchesResponse {

    private int id;
    private String name;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
