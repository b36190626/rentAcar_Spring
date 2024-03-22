package com.etiya.rentACar.business.dtos.responses.cars;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllCarsResponse {
    private int id;
    private int modelYear;
    private String plate;
    private int stateId;
//    private String color;
    private double dailyPrice;
    private int modelId;

}
