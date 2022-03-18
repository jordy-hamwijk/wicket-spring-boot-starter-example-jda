package com.giffing.wicket.spring.boot.example.model;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@NoArgsConstructor
public class Cheese implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSoortKaas() {
        return SoortKaas;
    }

    public void setSoortKaas(String soortKaas) {
        SoortKaas = soortKaas;
    }

    public String getLandHerkomst() {
        return LandHerkomst;
    }

    public void setLandHerkomst(String landHerkomst) {
        LandHerkomst = landHerkomst;
    }

    public Integer getGewicht() {
        return Gewicht;
    }

    public void setGewicht(Integer gewicht) {
        Gewicht = gewicht;
    }

    private String SoortKaas;
    private String LandHerkomst;
    private Integer Gewicht;


    public Cheese(String soortKaas, String landHerkomst, Integer gewicht) {

        SoortKaas = soortKaas;
        LandHerkomst = landHerkomst;
        Gewicht = gewicht;
    }
}
