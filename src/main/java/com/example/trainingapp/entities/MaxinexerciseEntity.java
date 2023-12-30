package com.example.trainingapp.entities;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;

@ToString
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "maxinexercise", schema = "pracalicencjacka_training_db", catalog = "")
public class MaxinexerciseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "bench", nullable = false)
    @Max(value = 500,message = "{validation.bench.size.too_high}")
    @Min(value = 1,message = "{validation.bench.size.too_low}")
    private double bench;
    @Basic
    @Column(name = "pullups",nullable = false)
    @Max(value = 500,message = "{validation.pullups.size.too_high}")
    @Min(value = 1 ,message = "{validation.pullups.size.too_low}")
    private int pullups;
    @Max(value = 500,message = "{validation.squad.size.too_high}")
    @Min(value = 1,message = "{validation.squad.size.too_low}")
    @Basic
    @Column(name = "squad",nullable = false)

    private double squad;
    @Max(value = 500,message = "{validation.deadlift.size.too_high}")
    @Min(value = 1,message = "{validation.deadlift.size.too_low}")
    @Basic
    @Column(name = "deadlift",nullable = false)


    private double deadlift;
    @Basic
    @Column(name = "NormalUser_id", nullable = false)
    private int normalUserId;
    @Basic
    @Column(name = "DayOfRecords" ,nullable = false)
    private LocalDate dayOfRecords;


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
