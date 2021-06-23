package com.example.demo.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Host {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title, anons, text,full_text;
    private int views;

public Host(){}

    public Host(String title, String anons, String full_text){
        this.title=title;
        this.anons=anons;
        this.full_text=full_text;
    }
}



