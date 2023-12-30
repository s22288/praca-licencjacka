package com.example.trainingapp.entities;

import com.example.trainingapp.controllers.NormalUserController;
import com.example.trainingapp.entities.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.apache.commons.math3.util.Precision;
import org.hibernate.annotations.Check;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(NormaluserEntity.class);


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Size(min = 2, message = "{validation.firstName.size.too_short}")
    @Size(max = 200, message = "{validation.name.size.too_long}")
    @Column(name = "firstName", nullable = false, length = 200)
    private String firstName;


    @Basic
    @Size(min = 2, message = "{validation.lastName.size.too_short}")
    @Size(max = 200, message = "{validation.name.size.too_long}")
    @Column(name = "lastName", nullable = false, length = 200)
    private String lastName;
    @Basic
    @Column(name = "birthDate", nullable = false)


    private LocalDate birthDate;
    @Basic
    @Column(name = "height", nullable = false, precision = 1)
    @DecimalMax(value = "250.0", message = "{validation.height.size.to_height}")
    @DecimalMin(value = "100.0", message = "{validation.height.size.to_short}")

    private double height;
    @Basic
    @Column(name = "weight", nullable = false, precision = 2)
    @DecimalMax(value = "300.0", message = "{validation.weight.size.to_height")
    @DecimalMin(value = "20.0", message = "{validation.weight.size.to_low}")

    private double weight;


    @Basic
    @Size(min = 2, message = "{validation.password.size.too_short}")
    @Size(max = 200, message = "{validation.password.size.too_long}")
    @Column(name = "password", nullable = false)
    private String password;

    @Basic
    @Size(min = 2, message = "{validation.email.size.too_short}")
    @Size(max = 200, message = "{validation.email.size.too_long}")

    @Column(name = "email", nullable = false,unique = true)
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
        logger.info("rola " + role.name());

        return List.of(new SimpleGrantedAuthority(role.name()));
    }

//    public boolean isAdmin() {
//        return getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"));
//    }
//
//    public boolean isUser() {
//        return getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER"));
//    }


    public Role getRole() {
        return role;
    }


    public void setRole(Role role) {
        this.role = role;
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
