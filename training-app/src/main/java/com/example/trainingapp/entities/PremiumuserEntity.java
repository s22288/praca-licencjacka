package com.example.trainingapp.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Entity
@Table(name = "premiumuser", schema = "pracalicencjacka_training_db", catalog = "")
@Getter
@Setter
@ToString
public class PremiumuserEntity {
    @Basic
    @Column(name = "hipsCircumference", nullable = false, precision = 2)
    private double hipsCircumference;
    @Basic
    @Column(name = "waistCircumference", nullable = false, precision = 2)
    private double waistCircumference;
    @Basic
    @Column(name = "startSubscription", nullable = false)
    private Date startSubscription;
    @Basic
    @Column(name = "endSubscription", nullable = false)
    private Date endSubscription;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "NormalUser_id", nullable = false)
    private int normalUserId;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PremiumuserEntity that = (PremiumuserEntity) o;

        if (Double.compare(that.hipsCircumference, hipsCircumference) != 0) return false;
        if (Double.compare(that.waistCircumference, waistCircumference) != 0) return false;
        if (normalUserId != that.normalUserId) return false;
        if (startSubscription != null ? !startSubscription.equals(that.startSubscription) : that.startSubscription != null)
            return false;
        if (endSubscription != null ? !endSubscription.equals(that.endSubscription) : that.endSubscription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(hipsCircumference);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(waistCircumference);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (startSubscription != null ? startSubscription.hashCode() : 0);
        result = 31 * result + (endSubscription != null ? endSubscription.hashCode() : 0);
        result = 31 * result + normalUserId;
        return result;
    }
}
