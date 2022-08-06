package dto;

import Model.Activity;
import Model.Camper;
import Model.Signup;
import lombok.Data;

import java.util.Set;

@Data
public class CamperDTO {
    private Long id;
    private String name;
    private int age;
    private Set<ActivityDTO> activities;
}
