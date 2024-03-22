package com.etiya.rentACar.business.dtos.requests;



import com.etiya.rentACar.entities.Model;
import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCarRequest {

    private int modelId;
    @NotNull
    @Min(value = 2005, message = "Production year must be between 2005 to 2024!")
    @Max(value = 2024, message = "Production year must be between 2005 to 2024!")
    private int modelYear;
    @NotNull
    @Pattern(regexp = "^(0[1-9]|[1-7][0-9]|8[01])[A-Z]{1,3}[0-9]{4,5}$", message = "Invalid plate number")
    private String plate;
//    @NotNull
//    @Min(0)
//    private String color; //

//    @NotNull --- FOR UPDATE CAR ---
//    private String state; //1-available, 2-unavailable, 3-under maintenance
    @NotNull
    @Min(1) //ENUM CLASS
    @Max(3) //ENUM CLASS
    private int state;
    @NotNull
    @Min(0)
    private double dailyPrice;
}