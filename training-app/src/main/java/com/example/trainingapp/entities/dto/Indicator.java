package com.example.trainingapp.entities.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Indicator {
    private  double BMI;
    private  String WHR;
    private  double IBW;
    private double Weight;
    private double Height;

}
