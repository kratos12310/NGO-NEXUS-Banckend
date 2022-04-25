package com.example.speproject.bean;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ngos")
public class Ngo {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String category;
    private String vision;
    private String address;
    private String loc;
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
    @Column(nullable=false)
    private String email;
    private String logo;
    //private String image1;
    //private String image2;
    //private String image3;

}
