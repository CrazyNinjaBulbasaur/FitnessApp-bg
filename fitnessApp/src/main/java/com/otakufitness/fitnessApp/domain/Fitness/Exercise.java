package com.otakufitness.fitnessApp.domain.Fitness;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "EXERCISES")
public class Exercise {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name="EXERCISE_ID", unique=true)
    private long id;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Column(name = "DESCRIPTION")
    private String description;

    @NotNull
    @Column(name = "CALORIES_BURNED_IN_ONE_HOUR")
    private int caloriesBurnedInOneHour;

    @OneToMany(
            targetEntity = FitnessActivity.class,
            mappedBy = "exercise",
            fetch = FetchType.LAZY
    )
    private List<FitnessActivity> fitnessActivities;
}
