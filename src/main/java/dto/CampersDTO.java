package dto;

import lombok.Data;

import java.util.Date;

@Data
public class CampersDTO {
    private Long id;
    private String name;
    private int age;
    private Date creationDate;
    private Date updatedDate;
}
