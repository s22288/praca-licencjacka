package com.example.trainingapp.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "premiumuser", schema = "pracalicencjacka_training_db", catalog = "")
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

    public double getHipsCircumference() {
        return hipsCircumference;
    }

    public void setHipsCircumference(double hipsCircumference) {
        this.hipsCircumference = hipsCircumference;
    }

    public double getWaistCircumference() {
        return waistCircumference;
    }

    public void setWaistCircumference(double waistCircumference) {
        this.waistCircumference = waistCircumference;
    }

    public Date getStartSubscription() {
        return startSubscription;
    }

    public void setStartSubscription(Date startSubscription) {
        this.startSubscription = startSubscription;
    }

    public Date getEndSubscription() {
        return endSubscription;
    }

    public void setEndSubscription(Date endSubscription) {
        this.endSubscription = endSubscription;
    }

    public int getNormalUserId() {
        return normalUserId;
    }

    public void setNormalUserId(int normalUserId) {
        this.normalUserId = normalUserId;
    }

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
