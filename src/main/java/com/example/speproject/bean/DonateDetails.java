package com.example.speproject.bean;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="donatedetails")
public class DonateDetails {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JsonBackReference(value="ngo-movement")
    @JoinColumn(name = "ngo_id")
    private Ngo ngo;

    @ManyToOne
    @JoinColumn(name = "donate_id")
    @JsonBackReference
    private Donor donor;

    private int donatedamt;
    private String volunteerto;
}
