package com.otakufitness.fitnessApp.domain.Fitness;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "EXERCISES")
public class FitnessActivity {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name="FITNESS_ACTIVITY_ID", unique=true)
    private long id;

    @NotNull
    @Column(name = "DURATION")
    private String duration;

    @NotNull
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "EXERCISE_ID")
    private Exercise exercise;
}
