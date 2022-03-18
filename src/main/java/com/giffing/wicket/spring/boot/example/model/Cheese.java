package com.giffing.wicket.spring.boot.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cheese implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Soorten;
    private String LandHerkomst;
    private String Gewicht;


    public Cheese(String soorten, String landHerkomst, String gewicht) {

        Soorten = soorten;
        LandHerkomst = landHerkomst;
        Gewicht = gewicht;
    }

}
