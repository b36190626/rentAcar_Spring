package com.etiya.rentacar.business.dtos.requests.car;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {

    private int id;

    @NotNull
    private int modelYear;

    @NotBlank(message = "Car plate cannot be blank")
    @NotEmpty(message = "Car plate cannot be empty")
    private String plate;

    @Size(min = 1, max = 3)
    @NotBlank(message = "Car state cannot be blank")
    @NotEmpty(message = "Car state cannot be empty")
    private int state;

    @NotBlank(message = "Car daily price cannot be blank")
    @NotEmpty(message = "Car daily price cannot be empty")
    private double dailyPrice;

    @NotBlank(message = "Model ID cannot be blank")
    @NotEmpty(message = "Model ID cannot be empty")
    private int modelId;

    @NotBlank(message = "Car kilometer cannot be blank")
    @NotEmpty(message = "Car kilometer cannot be empty")
    private double kilometer;
}
