package com.example.demo.Model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "Campers")
public class Camper {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @Min(8)
    @Max(18)
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