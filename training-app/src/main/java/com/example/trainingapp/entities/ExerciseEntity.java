package com.example.trainingapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
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
//    @Basic
//    @Column(name = "dayName")
//
//private String  dayName;


    @ManyToMany
    @JoinTable(name = "trainingexercise",joinColumns = @JoinColumn( name ="exercise_id" ),inverseJoinColumns = @JoinColumn(name = "training_id"))
    private Set<TrainingEntity> trainingEntitySet = new HashSet<>();



    @ManyToMany
    @JoinTable(name = "exercisebodypart",joinColumns = @JoinColumn( name ="exercise_id" ),inverseJoinColumns = @JoinColumn(name = "body_part_id"))
    private Set<BodypartEntity> bodypartEntitySet = new HashSet<>();

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

//    public String getDayName() {
//        return dayName;
//    }
//
//    public void setDayName(String dayName) {
//        this.dayName = dayName;
//    }

    public Set<BodypartEntity> getBodypartEntitySet() {
        return bodypartEntitySet;
    }

    public void setBodypartEntitySet(Set<BodypartEntity> bodypartEntitySet) {
        this.bodypartEntitySet = bodypartEntitySet;
    }



    public Set<TrainingEntity> getTrainingEntitySet() {
        return trainingEntitySet;
    }

    public void setTrainingEntitySet(Set<TrainingEntity> trainingEntitySet) {
        this.trainingEntitySet = trainingEntitySet;
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
        return id == that.id && series == that.series && reps == that.reps && levelOfAdvance == that.levelOfAdvance && trainingMachineId == that.trainingMachineId && Objects.equals(name, that.name) && Objects.equals(photo, that.photo) && Objects.equals(trainingEntitySet, that.trainingEntitySet) && Objects.equals(bodypartEntitySet, that.bodypartEntitySet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, photo, series, reps, levelOfAdvance, trainingMachineId, trainingEntitySet, bodypartEntitySet);
    }


}
