package com.etiya.rentacar.api.controllers;

import com.etiya.rentacar.business.abstracts.RentalBranchService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rentalBranches")
@AllArgsConstructor
public class RentalBranchesConroller {
    private RentalBranchService rentalBranchService;


}
