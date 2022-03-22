package com.giffing.wicket.spring.boot.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity

public class Cheese implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Cheese() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSoortKaas() {
        return soortKaas;
    }

    public void setSoortKaas(String soortKaas) {
        this.soortKaas = soortKaas;
    }

    public String getLandHerkomst() {
        return landHerkomst;
    }

    public void setLandHerkomst(String landHerkomst) {
        this.landHerkomst = landHerkomst;
    }

    public Integer getGewicht() {
        return gewicht;
    }

    public void setGewicht(Integer gewicht) {
        this.gewicht = gewicht;
    }

    private String soortKaas;
    private String landHerkomst;
    private Integer gewicht;


    public Cheese(String soortKaas, String landHerkomst, Integer gewicht) {

        this.soortKaas = soortKaas;
        this.landHerkomst = landHerkomst;
        this.gewicht = gewicht;
    }

    public void setDate(Date date) {
    }

    public void setText(String s) {
    }

    public Object getDate() {
        return null;
    }

    public String getText() {
        return null;
    }
}
