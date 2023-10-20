package com.example.trainingapp.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "exercise", schema = "pracalicencjacka_training_db", catalog = "")
public class ExerciseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = false, length = 200)
    private String name;
    @Basic
    @Column(name = "photo", nullable = false, length = 2000)
    private String photo;
    @Basic
    @Column(name = "series", nullable = false)
    private int series;

    @Basic
    @Column(name = "reps", nullable = false)
    private int reps;
    @Basic
    @Column(name = "LevelOfAdvance", nullable = false)
    private int levelOfAdvance;
    @Basic
    @Column(name = "TrainingMachine_id", nullable = false)
    private int trainingMachineId;


    @ManyToMany
    @JoinTable(name = "trainingexercise",joinColumns = @JoinColumn( name ="exercise_id" ),inverseJoinColumns = @JoinColumn(name = "training_id"))
    private Set<TrainingEntity> trainingEntitySet = new HashSet<>();
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getLevelOfAdvance() {
        return levelOfAdvance;
    }

    public void setLevelOfAdvance(int levelOfAdvance) {
        this.levelOfAdvance = levelOfAdvance;
    }

    public int getTrainingMachineId() {
        return trainingMachineId;
    }

    public void setTrainingMachineId(int trainingMachineId) {
        this.trainingMachineId = trainingMachineId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExerciseEntity that = (ExerciseEntity) o;

        if (id != that.id) return false;
        if (series != that.series) return false;
        if (levelOfAdvance != that.levelOfAdvance) return false;
        if (trainingMachineId != that.trainingMachineId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (photo != null ? !photo.equals(that.photo) : that.photo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        result = 31 * result + series;
        result = 31 * result + levelOfAdvance;
        result = 31 * result + trainingMachineId;
        return result;
    }
}
