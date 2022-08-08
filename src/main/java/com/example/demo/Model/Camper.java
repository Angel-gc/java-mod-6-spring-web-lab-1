package com.example.demo.Model;

import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Campers")
public class Camper {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String name;

    @Min(8)
    @Max(18)
    @NonNull
    private int age;

//    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    private LocalDateTime creationDate;

//    @Temporal(TemporalType.DATE)
    @Column(name = "updated_at")
    private LocalDateTime updatedDate;

    @OneToMany(mappedBy = "camper", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    List<Signup> signUps = new ArrayList<>();
}
