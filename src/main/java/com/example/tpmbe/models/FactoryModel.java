package com.example.tpmbe.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class FactoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String rowNum;

    @Column(name = "Position")
    private String position;

    @Column(name = "CurrentLocation")
    private String location;

}
