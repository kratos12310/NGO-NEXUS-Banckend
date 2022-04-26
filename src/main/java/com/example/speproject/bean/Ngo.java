package com.example.speproject.bean;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ngos")
public class Ngo {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "ngo_id")
    private Long id;
    @Column(nullable=false)
    private String name;
    @Column(nullable=false)
    private String category;
    @Column(nullable=false)
    private String vision;
    @Column(nullable=false)
    private String address;
    @Column(nullable=false)
    private String loc;
    @Column(nullable=false)
    private String phoneno;
    @Lob
    private String campaign1;
    @Lob
    private String campaign2;
    @Lob
    private String campaign3;

    @Column(nullable = false)
    private String password;
    @Lob
    private String desc;
    @Column(unique = true,nullable=false)
    private String email;
    private String logo;

    @OneToMany(mappedBy = "ngo", cascade = CascadeType.ALL)
    @JsonManagedReference(value="ngo-movement")
    private List<DonateDetails> donatedetails;
    //private String image1;
    //private String image2;
    //private String image3;

}
