package com.example.tpmbe.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class TPMDashboardModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer rowNum;

    @Column(name = "McName")
    private String mcName;

    @Column(name="McType")
    private String mcType;

    @Column(name = "McBrand")
    private String mcBrand;

    @Column(name = "McModel")
    private String mcModel;

    @Column(name = "McSerialNumber")
    private String mcSerialNumber;

    @Column(name = "CurrentLocation")
    private String currentLocation;

    @Column(name = "Position")
    private String position;

    @Column(name = "TPMDate")
    private String lastTPMDate;

    @Column(name = "TPMDays")
    private Integer tpmSchedule;

    @Column(name = "TimeLeft")
    private Integer timeLeft;

    @Column(name = "Status")
    private String status;

    @JsonIgnore
    private Integer totalElements;
}
