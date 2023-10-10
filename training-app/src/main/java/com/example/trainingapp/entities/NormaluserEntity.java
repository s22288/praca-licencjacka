package com.example.trainingapp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

@Entity
@Table(name = "normaluser", schema = "pracalicencjacka_training_db", catalog = "")
@Getter
@Setter
public class NormaluserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "firstName", nullable = false, length = 200)
    private String firstName;
    @Basic
    @Column(name = "lastName", nullable = false, length = 200)
    private String lastName;
    @Basic
    @Column(name = "birthDate", nullable = false)
    private Date birthDate;
    @Basic
    @Column(name = "height", nullable = false, precision = 1)
    private double height;
    @Basic
    @Column(name = "weight", nullable = false, precision = 2)
    private double weight;


    @Basic
    @Column(name = "password", nullable = false, length = 300)
    private String password;

    @Basic
    @Column(name = "mail", nullable = false, length = 200)
    private String mail;
    @Basic
    @Column(name = "photo", nullable = false, length = 2000)
    private String photo;
    @Basic
    @Column(name = "palfactor", nullable = false, precision = 3)
    private double palfactor;


    @Basic
    @Column(name = "sex", nullable = false)
    private boolean sex;

    @Basic
    @Column(name = "Authority_id", nullable = false)
    private int authorityId;


    public long calculateAge(){
       return   ChronoUnit.YEARS.between((Temporal) birthDate,LocalDate.now());

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NormaluserEntity that = (NormaluserEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.height, height) != 0) return false;
        if (Double.compare(that.weight, weight) != 0) return false;
        if (Double.compare(that.palfactor, palfactor) != 0) return false;

        if (authorityId != that.authorityId) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (birthDate != null ? !birthDate.equals(that.birthDate) : that.birthDate != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (mail != null ? !mail.equals(that.mail) : that.mail != null) return false;
        if (photo != null ? !photo.equals(that.photo) : that.photo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        temp = Double.doubleToLongBits(palfactor);
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        result = 31 * result + authorityId;
        return result;
    }
}
