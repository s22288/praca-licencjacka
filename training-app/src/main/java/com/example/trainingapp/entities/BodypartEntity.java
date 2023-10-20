package com.example.trainingapp.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bodypart", schema = "pracalicencjacka_training_db", catalog = "")
public class BodypartEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "description", nullable = false, length = 200)
    private String description;
    @Basic
    @Column(name = "url", nullable = false, length = 200)
    private String url;


    @ManyToMany
    @JoinTable(name = "exercisebodypart",joinColumns = @JoinColumn( name ="body_part_id" ),inverseJoinColumns = @JoinColumn(name = "exercise_id"))
    private Set<ExerciseEntity> exerciseEntitySet = new HashSet<>();


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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BodypartEntity that = (BodypartEntity) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
}
