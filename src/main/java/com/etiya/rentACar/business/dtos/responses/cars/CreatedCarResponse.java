package com.etiya.rentACar.business.dtos.responses.cars;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedCarResponse {
    private int id;
    private int modelYear;
    private String plate;
    private int state;
    //    private String color;
    private double dailyPrice;
    private int modelId;
    LocalDateTime createdTime;
}
