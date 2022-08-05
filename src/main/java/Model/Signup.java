package Model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

@Data
@Table(name = "Signups")
public class Signup {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

//    @Column(name = "camper_id")
//    private int camperId;
//
//    @Column(name = "activity_id")
//    private int activityId;

    @Min(0)
    @Max(23)
    @Column(name = "hour_of_the_day", nullable = false)
    private int time;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    private Date creationDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "updated_at")
    private Date updateDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Activity activity;
    @ManyToOne(fetch = FetchType.LAZY)
    private Camper camper;
}
