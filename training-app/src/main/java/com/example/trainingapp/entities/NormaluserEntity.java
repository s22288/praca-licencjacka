package com.example.trainingapp.entities;

import com.example.trainingapp.entities.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;
import org.apache.commons.math3.util.Precision;
import org.hibernate.annotations.Check;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.List;

@Entity
@Builder
@Table(name = "normaluser", schema = "pracalicencjacka_training_db", catalog = "")
@Getter
@Setter
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor

public class NormaluserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


    private LocalDate birthDate;
    @Basic
    @Column(name = "height", nullable = false, precision = 1)
    @DecimalMax(value = "1000.0", message = "too much heigh")
    @DecimalMin(value = "0.0", message = "0.0")

    private double height;
    @Basic
    @Column(name = "weight", nullable = false, precision = 2)
    @DecimalMax(value = "600.0", message = "too much weight")
    @DecimalMin(value = "0.0", message = "cant weight under 0")

    private double weight;


    @Basic
    @Column(name = "password", nullable = false, length = 300)
    private String password;

    @Basic
    @Column(name = "email", nullable = false, length = 200)
    private String email;
    @Basic
    @Column(name = "photo", length = 2000)
    private String photo;
    @Basic
    @Column(name = "palfactor", nullable = false, precision = 3)
    @DecimalMax(value = "5.0", message = "to high pal factor")
    @DecimalMin(value = "-5.0", message = "to low pal factor")

    private double palfactor;


    @Basic
    @Column(name = "sex", nullable = false)
    private boolean sex;


    @Enumerated(EnumType.STRING)
    private Role role;


    public long calculateAgeFromBirthDate() {
        return ChronoUnit.YEARS.between(birthDate, LocalDate.now());
    }

    public double calculatePPM() {
        if (sex) {
            return 66.47 + (13.75 * this.weight) + (5 * this.height) - (6.75 * calculateAgeFromBirthDate());

        }
        return 665.09 + (9.56 * this.weight) + (1.85 * this.height) - (4.67 * calculateAgeFromBirthDate());

    }

    public double calculateCPM() {
        return Precision.round(getPalfactor() * calculatePPM(), 2);
    }


    public double roundValues(double value) {
        value = value * 100;
        value = Math.round(value);
        value = value / 100;
        return value;
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

        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (birthDate != null ? !birthDate.equals(that.birthDate) : that.birthDate != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
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
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        temp = Double.doubleToLongBits(palfactor);
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        return result;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {

        return true;
    }

    @Override
    public String toString() {
        return "NormaluserEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", height=" + height +
                ", weight=" + weight +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", photo='" + photo + '\'' +
                ", palfactor=" + palfactor +
                ", sex=" + sex +
                ", role=" + role +
                '}';
    }
}
