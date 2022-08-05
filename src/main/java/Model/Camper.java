package Model;

import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Table(name = "Campers")
public class Camper {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Min(8)
    @Max(18)
    private int age;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    private Date creationDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "updated_at")
    private Date updatedDate;

    @OneToMany(mappedBy = "camper")
    List<Signup> signUps = new ArrayList<>();
}
