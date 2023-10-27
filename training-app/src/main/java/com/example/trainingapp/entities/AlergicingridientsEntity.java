package com.example.trainingapp.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "alergicingridients", schema = "pracalicencjacka_training_db", catalog = "")
public class AlergicingridientsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = false, length = 200)
    private String name;
    @Basic
    @Column(name = "description", nullable = false)
    private String description;
    @Basic
    @Column(name = "photo", nullable = false,length = 2000)
    private String photo;

    @ManyToMany
    @JoinTable(name = "mealalergen",joinColumns = @JoinColumn( name ="alergicingridientsId" ),inverseJoinColumns = @JoinColumn(name = "mealId"))
    private Set<MealEntity> mealEntitySet = new HashSet<>();



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

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AlergicingridientsEntity that = (AlergicingridientsEntity) o;

        if (id != that.id) return false;
        if (description != that.description) return false;
        if (photo != that.photo) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
