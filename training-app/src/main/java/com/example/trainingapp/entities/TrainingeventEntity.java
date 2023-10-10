package com.example.trainingapp.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "trainingevent", schema = "pracalicencjacka_training_db", catalog = "")
public class TrainingeventEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "description", nullable = false)
    private int description;
    @Basic
    @Column(name = "localozation", nullable = false, length = 300)
    private String localozation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public String getLocalozation() {
        return localozation;
    }

    public void setLocalozation(String localozation) {
        this.localozation = localozation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrainingeventEntity that = (TrainingeventEntity) o;

        if (id != that.id) return false;
        if (description != that.description) return false;
        if (localozation != null ? !localozation.equals(that.localozation) : that.localozation != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + description;
        result = 31 * result + (localozation != null ? localozation.hashCode() : 0);
        return result;
    }
}
