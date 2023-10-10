package com.example.trainingapp.entities;

import jakarta.persistence.*;

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
    private int description;
    @Basic
    @Column(name = "photo", nullable = false)
    private int photo;

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

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
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
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + description;
        result = 31 * result + photo;
        return result;
    }
}
