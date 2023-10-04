package com.otakufitness.fitnessApp.domain.fitness;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exercise {

    @Id
    @GeneratedValue
    @NotNull
    @Column(unique=true)
    private long id;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private int caloriesBurnedInSixtyMinutes;
    @OneToMany(
            mappedBy = "exercise"
    )
    private List<FitnessActivity> fitnessActivities;
}
