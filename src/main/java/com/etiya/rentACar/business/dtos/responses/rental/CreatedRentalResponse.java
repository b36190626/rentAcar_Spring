package com.etiya.rentacar.business.dtos.responses.rental;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedRentalResponse {
    private int carId;
    private int customerId;

    private LocalDateTime rentStartDate;
    private LocalDateTime rentEndDate;

    private int rentStartKilometer;

}
