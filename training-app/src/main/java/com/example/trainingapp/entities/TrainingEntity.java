package com.example.trainingapp.entities;

import com.example.trainingapp.entities.enums.TypeOfTraining;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
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
}
