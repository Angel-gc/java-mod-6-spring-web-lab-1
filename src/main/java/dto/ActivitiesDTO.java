package dto;

import lombok.Data;

import java.util.Set;
@Data
public class ActivitiesDTO {
    private Long id;
    private String name;
    Set<SignupsDTO> signUps;
}
