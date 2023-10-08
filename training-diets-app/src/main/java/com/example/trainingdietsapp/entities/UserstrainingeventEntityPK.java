package com.example.trainingdietsapp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class UserstrainingeventEntityPK implements Serializable {
    @Column(name = "TrainingCalendar_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trainingCalendarId;
    @Column(name = "PremiumUser_NormalUser_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int premiumUserNormalUserId;

    public int getTrainingCalendarId() {
        return trainingCalendarId;
    }

    public void setTrainingCalendarId(int trainingCalendarId) {
        this.trainingCalendarId = trainingCalendarId;
    }

    public int getPremiumUserNormalUserId() {
        return premiumUserNormalUserId;
    }

    public void setPremiumUserNormalUserId(int premiumUserNormalUserId) {
        this.premiumUserNormalUserId = premiumUserNormalUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserstrainingeventEntityPK that = (UserstrainingeventEntityPK) o;

        if (trainingCalendarId != that.trainingCalendarId) return false;
        if (premiumUserNormalUserId != that.premiumUserNormalUserId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = trainingCalendarId;
        result = 31 * result + premiumUserNormalUserId;
        return result;
    }
}
