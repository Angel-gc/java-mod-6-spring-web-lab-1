package Model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Activities")
public class Activity {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private int difficulty;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    private Date creationDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "updated_at")
    private Date updateDate;

    @OneToMany(mappedBy = "activity")
    List<Signup> signUps = new ArrayList<>();
}
