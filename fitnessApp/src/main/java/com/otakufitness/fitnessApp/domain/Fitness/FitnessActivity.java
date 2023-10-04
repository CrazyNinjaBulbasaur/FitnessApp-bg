package com.otakufitness.fitnessApp.domain.Fitness;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FitnessActivity {
    @Id
    @GeneratedValue
    @NotNull
    @Column(unique=true)
    private long id;

    @NotNull
    private String duration;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "EXERCISE_ID")
    private Exercise exercise;
}
