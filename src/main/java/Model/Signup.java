package Model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Data
@Table(name = "Signups")
public class Signup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Min(0)
    @Max(23)
    @NotNull
    @Column(name = "hour_of_the_day")
    private int time;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    private LocalDateTime creationDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "updated_at")
    private LocalDateTime updateDate;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;

    @ManyToOne
    @JoinColumn(name = "camper_id")
    private Camper camper;
}
