package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CamperDTO {
    private Long id;
    private String name;
    private int age;
    private Set<ActivityDTO> activities = new HashSet<>();
}
