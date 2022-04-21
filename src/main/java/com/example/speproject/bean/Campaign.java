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
public class Campaign {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long campg_id;

    private String campg_name;
    private String campg_desc;
    private String campg_photo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private Ngo ngo;

}
