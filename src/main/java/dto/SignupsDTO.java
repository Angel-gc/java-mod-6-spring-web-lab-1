package dto;

import Model.Camper;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class SignupsDTO {
    private Long id;
    private int time;
    private Date creationDate;
    private Date updatedDate;
    private Set<Camper> campers;
}
