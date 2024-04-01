package com.etiya.rentacar.business.dtos.requests.rental;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRentalRequest {
    private int carId;
    private int customerId;
    private LocalDateTime rentStartDate;
    private LocalDateTime rentEndDate;
//    private LocalDateTime returnDate;
//    private int rentStartKilometer;
//    private int rentEndKilometer;


}
