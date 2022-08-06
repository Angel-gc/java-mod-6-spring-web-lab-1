package Model;

import lombok.Data;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Activities")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;
    private int difficulty;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    private LocalDateTime creationDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "updated_at")
    private LocalDateTime updateDate;

    @OneToMany(mappedBy = "activity", cascade = CascadeType.REMOVE)
    List<Signup> signUps = new ArrayList<>();
}
