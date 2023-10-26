package com.example.trainingapp.entities;

import jakarta.persistence.*;
import lombok.ToString;

import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.Set;
@ToString
@Entity
@Table(name = "trainingevent", schema = "pracalicencjacka_training_db", catalog = "")
public class TrainingeventEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "description", nullable = false)
    private String description;
    @Basic
    @Column(name = "localozation", nullable = false, length = 300)
    private String localozation;

    @Basic
    @Column(name = "day", nullable = false, length = 300)
    private String day;


    @ManyToMany
    @JoinTable(name = "userstrainingevent",joinColumns = @JoinColumn( name ="training_calendar_id" ),inverseJoinColumns = @JoinColumn(name = "premium_user_normal_user_id"))
    private Set<PremiumuserEntity> premiumuserEntitySet = new HashSet<>();


    public void setPremiumuserEntitySet(Set<PremiumuserEntity> premiumuserEntitySet) {
        this.premiumuserEntitySet = premiumuserEntitySet;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocalozation(String localozation) {
        this.localozation = localozation;
    }

    public void setDay(String day) {
        this.day = day;



    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getLocalozation() {
        return localozation;
    }

    public String getDay() {
        return day;
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
        result = 31 * result + (localozation != null ? localozation.hashCode() : 0);
        return result;
    }
}
