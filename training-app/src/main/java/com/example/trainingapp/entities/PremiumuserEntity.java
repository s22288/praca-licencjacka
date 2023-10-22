package com.example.trainingapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "premiumuser", schema = "pracalicencjacka_training_db", catalog = "")
@Getter
@Setter
@ToString
@AllArgsConstructor



public class PremiumuserEntity extends NormaluserEntity {


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
    @ManyToMany
    @JoinTable(name = "userstrainingevent",joinColumns = @JoinColumn( name ="premium_user_normal_user_id" ),inverseJoinColumns = @JoinColumn(name = "training_calendar_id"))
    private Set<TrainingeventEntity> trainingeventEntitySet = new HashSet<>();

    public PremiumuserEntity() {

    }





    public  double calculateBMI(){
        return  getWeight() / Math.pow(getHeight(),2);

    }
    public double  calculateIBW(){
        if(isSex()){
       double value =     (getHeight() - 100);
        return  value- (0.10 * value);
        }
        double value =     (getHeight() - 100);

        return  value- (0.05 * value);
    }

    public String calculateWHR(){
        double WHR = waistCircumference/ hipsCircumference;
        if(isSex()){
          if(WHR>1){
              return "Otyłość aneroidalna(jabłko)";
          }
          return "Otyłość ginoidalna gruszka";
        }

        if(WHR>0.8){
            return "Otyłość aneroidalna(jabłko)";

        }
        return "Otyłość aneroidalna(jabłko)";

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PremiumuserEntity that = (PremiumuserEntity) o;

        if (Double.compare(that.hipsCircumference, hipsCircumference) != 0) return false;
        if (Double.compare(that.waistCircumference, waistCircumference) != 0) return false;
//        if (normalUserId != that.normalUserId) return false;
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
//        result = 31 * result + normalUserId;
        return result;
    }
}
