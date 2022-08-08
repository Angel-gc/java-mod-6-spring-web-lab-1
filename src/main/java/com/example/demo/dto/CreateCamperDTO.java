package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.lang.NonNull;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCamperDTO {
    @NotNull
    private String name;
    @Min(8)
    @Max(18)
    @NotNull
    private int age;
}
