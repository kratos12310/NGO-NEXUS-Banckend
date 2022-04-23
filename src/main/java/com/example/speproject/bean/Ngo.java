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
    private String campaign1;
    private String campaign2;
    private String campaign3;

    @Column(nullable = false)
    private String password;
   // @Column(columnDefinition="text")
    private String desc;
    private String email;
    private String logo;
    //private String image1;
    //private String image2;
    //private String image3;

}
