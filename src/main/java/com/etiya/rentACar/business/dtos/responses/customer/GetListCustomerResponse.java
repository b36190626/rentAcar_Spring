package com.etiya.rentacar.business.dtos.responses.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListCustomerResponse {
    private int id;
    private String name;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
