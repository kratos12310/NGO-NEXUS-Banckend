package com.example.speproject.bean;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="donor")
public class Donor {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "donor_id")
    private Long id;
    @Column(nullable=false)
    private String name;
    @Column(unique = true,nullable=false)
    private String email;
    @Column(nullable=false)
    private String password;
    @Column(nullable=false)
    private String phoneno;
    @Column(nullable=false)
    private String type;
    @OneToMany(mappedBy = "donor")
    @JsonManagedReference
    private List<DonateDetails> donatedetails;
}
