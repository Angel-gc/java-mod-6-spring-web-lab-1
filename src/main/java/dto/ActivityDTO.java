package dto;

import lombok.Data;

import java.util.Set;
@Data
public class ActivityDTO {
    private Long id;
    private String name;
    private int difficulty;
    Set<SignupDTO> signUps;
}
