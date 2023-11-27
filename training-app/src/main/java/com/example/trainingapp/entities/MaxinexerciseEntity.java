package com.example.trainingapp.entities;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
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

    private double bench;
    @Basic
    @Column(name = "pullups",nullable = false)

    private int pullups;
    @Basic
    @Column(name = "squad",nullable = false)

    private double squad;
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
