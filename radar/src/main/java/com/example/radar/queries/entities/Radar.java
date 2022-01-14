package com.example.radar.queries.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Radar {
    @javax.persistence.Id
    private  String Id;
    private  Double vitesse ;
    private String latitude;
    private String longitude;
}
