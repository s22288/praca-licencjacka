package com.example.trainingapp.entities;

import com.example.trainingapp.entities.enums.TypeOfTraining;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "training", schema = "pracalicencjacka_training_db", catalog = "")
public class TrainingEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "description", nullable = false, length = 500)
    private String description;
    @Basic
    @Column(name = "maxAge", nullable = false)
    private int maxAge;
    @Basic
    @Column(name = "NormalUser_id", nullable = false)
    private int normalUserId;
    @Basic
    @Column(name = "treiningType", nullable = false, length = 200)
    @Enumerated(EnumType.STRING)
    private TypeOfTraining treiningType;


    @ManyToMany
    @JoinTable(name = "trainingexercise",joinColumns = @JoinColumn( name ="training_id" ),inverseJoinColumns = @JoinColumn(name = "exercise_id"))
    private Set<ExerciseEntity> exerciseEntitySet = new HashSet<>();



    public Set<ExerciseEntity> getExerciseEntitySet() {
        return exerciseEntitySet;
    }

    public void setExerciseEntitySet(Set<ExerciseEntity> exerciseEntitySet) {
        this.exerciseEntitySet = exerciseEntitySet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrainingEntity that = (TrainingEntity) o;

        if (id != that.id) return false;
        if (maxAge != that.maxAge) return false;
        if (normalUserId != that.normalUserId) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (treiningType != null ? !treiningType.equals(that.treiningType) : that.treiningType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + maxAge;
        result = 31 * result + normalUserId;
        result = 31 * result + (treiningType != null ? treiningType.hashCode() : 0);
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public TypeOfTraining getTreiningType() {
        return treiningType;
    }

    public void setTreiningType(TypeOfTraining treiningType) {
        this.treiningType = treiningType;
    }

    @JsonIgnore
    public int getNormalUserId() {
        return normalUserId;
    }

    @JsonIgnore
    public void setNormalUserId(int normalUserId) {
        this.normalUserId = normalUserId;
    }

    @Override
    public String toString() {
        return "TrainingEntity{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", maxAge=" + maxAge +
                ", normalUserId=" + normalUserId +
                ", treiningType=" + treiningType +
                ", exerciseEntitySet=" + exerciseEntitySet +
                '}';
    }
}
