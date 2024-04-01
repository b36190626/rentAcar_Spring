package com.etiya.rentacar.business.dtos.requests.customer;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest {

    private String username;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String companyName;
}
