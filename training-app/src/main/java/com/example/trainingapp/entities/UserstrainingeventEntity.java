package com.example.trainingapp.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "userstrainingevent", schema = "pracalicencjacka_training_db", catalog = "")
@IdClass(UserstrainingeventEntityPK.class)
public class UserstrainingeventEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "TrainingCalendar_id", nullable = false)
    private int trainingCalendarId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "PremiumUser_NormalUser_id", nullable = false)
    private int premiumUserNormalUserId;
    @Basic
    @Column(name = "DayOfWeek", nullable = false, length = 200)
    private String dayOfWeek;

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

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserstrainingeventEntity that = (UserstrainingeventEntity) o;

        if (trainingCalendarId != that.trainingCalendarId) return false;
        if (premiumUserNormalUserId != that.premiumUserNormalUserId) return false;
        if (dayOfWeek != null ? !dayOfWeek.equals(that.dayOfWeek) : that.dayOfWeek != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = trainingCalendarId;
        result = 31 * result + premiumUserNormalUserId;
        result = 31 * result + (dayOfWeek != null ? dayOfWeek.hashCode() : 0);
        return result;
    }
}
