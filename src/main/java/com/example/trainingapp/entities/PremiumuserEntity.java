package com.example.trainingapp.entities;

import com.example.trainingapp.entities.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.time.LocalDate;
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
    @Max(value = 600,message = "{validation.hipsCircumference.size.too_big}")
    @Min(value = 40,message = "{validation.hipsCircumference.size.too_small}")
    private double hipsCircumference;
    @Basic
    @Column(name = "waistCircumference", nullable = false, precision = 2)
    @Max(value = 600,message = "{validation.waistCircumference.size.too_big}")
    @Min(value = 40,message = "{validation.waistCircumference.size.too_small}")
    private double waistCircumference;
    @Basic
    @Column(name = "startSubscription", nullable = false)
    private LocalDate startSubscription;
    @Basic
    @Column(name = "endSubscription", nullable = false)
    private LocalDate endSubscription;
    @ManyToMany
    @JoinTable(name = "userstrainingevent",joinColumns = @JoinColumn( name ="premium_user_normal_user_id" ),inverseJoinColumns = @JoinColumn(name = "training_calendar_id"))
    private Set<TrainingeventEntity> trainingeventEntitySet = new HashSet<>();

    public PremiumuserEntity() {

    }


    public PremiumuserEntity(int id, String firstName, String lastName, LocalDate birthDate, @DecimalMax(value = "1000.0", message = "too much heigh") @DecimalMin(value = "0.0", message = "0.0") double height, @DecimalMax(value = "600.0", message = "too much weight") @DecimalMin(value = "0.0", message = "cant weight under 0") double weight, String password, String email, String photo, @DecimalMax(value = "5.0", message = "to high pal factor") @DecimalMin(value = "-5.0", message = "to low pal factor") double palfactor, boolean sex, Role role, double hipsCircumference, double waistCircumference, LocalDate startSubscription, LocalDate endSubscription, Set<TrainingeventEntity> trainingeventEntitySet) {
        super(id, firstName, lastName, birthDate, height, weight, password, email, photo, palfactor, sex, role);
        this.hipsCircumference = hipsCircumference;
        this.waistCircumference = waistCircumference;
        this.startSubscription = startSubscription;
        this.endSubscription = endSubscription;
        this.trainingeventEntitySet = trainingeventEntitySet;
    }

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

    public LocalDate getStartSubscription() {
        return startSubscription;
    }

    public void setStartSubscription(LocalDate startSubscription) {
        this.startSubscription = startSubscription;
    }

    public LocalDate getEndSubscription() {
        return endSubscription;
    }

    public void setEndSubscription(LocalDate endSubscription) {
        this.endSubscription = endSubscription;
    }

    public Set<TrainingeventEntity> getTrainingeventEntitySet() {
        return trainingeventEntitySet;
    }

    public void setTrainingeventEntitySet(Set<TrainingeventEntity> trainingeventEntitySet) {
        this.trainingeventEntitySet = trainingeventEntitySet;
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
