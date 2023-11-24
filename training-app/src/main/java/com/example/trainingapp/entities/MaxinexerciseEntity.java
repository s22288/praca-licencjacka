package com.example.trainingapp.entities;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.ToString;

import java.sql.Date;
import java.time.LocalDate;

@ToString
@Entity
@Table(name = "maxinexercise", schema = "pracalicencjacka_training_db", catalog = "")
public class MaxinexerciseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "bench", precision = 2)
    @DecimalMax(value = "999.0",message = "weigth too big") @DecimalMin(value = "1.0",message = "weight to small")

    private double bench;
    @Basic
    @Column(name = "pullups")
    @DecimalMax(value = "999.0",message = "weigth too big") @DecimalMin(value = "1.0",message = "weight to small")

    private int pullups;
    @Basic
    @Column(name = "squad", precision = 2)
    @DecimalMax(value = "999.0",message = "weigth too big") @DecimalMin(value = "1.0",message = "weight to small")

    private double squad;
    @Basic
    @Column(name = "deadlift", precision = 2)
    @DecimalMax(value = "999.0",message = "weigth too big") @DecimalMin(value = "1.0",message = "weight to small")


    private double deadlift;
    @Basic
    @Column(name = "NormalUser_id", nullable = false)
    private int normalUserId;
    @Basic
    @Column(name = "DayOfRecords")
    private LocalDate dayOfRecords;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBench() {
        return bench;
    }

    public void setBench(double bench) {
        this.bench = bench;
    }

    public int getPullups() {
        return pullups;
    }

    public void setPullups(int pullups) {
        this.pullups = pullups;
    }

    public double getSquad() {
        return squad;
    }

    public void setSquad(double squad) {
        this.squad = squad;
    }

    public double getDeadlift() {
        return deadlift;
    }

    public void setDeadlift(double deadlift) {
        this.deadlift = deadlift;
    }

    public int getNormalUserId() {
        return normalUserId;
    }

    public void setNormalUserId(int normalUserId) {
        this.normalUserId = normalUserId;
    }

    public LocalDate getDayOfRecords() {
        return dayOfRecords;
    }

    public void setDayOfRecords(LocalDate dayOfRecords) {
        this.dayOfRecords = dayOfRecords;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaxinexerciseEntity that = (MaxinexerciseEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.bench, bench) != 0) return false;
        if (pullups != that.pullups) return false;
        if (Double.compare(that.squad, squad) != 0) return false;
        if (Double.compare(that.deadlift, deadlift) != 0) return false;
        if (normalUserId != that.normalUserId) return false;
        if (dayOfRecords != null ? !dayOfRecords.equals(that.dayOfRecords) : that.dayOfRecords != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        temp = Double.doubleToLongBits(bench);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + pullups;
        temp = Double.doubleToLongBits(squad);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(deadlift);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + normalUserId;
        result = 31 * result + (dayOfRecords != null ? dayOfRecords.hashCode() : 0);
        return result;
    }
}
