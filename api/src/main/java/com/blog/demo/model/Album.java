package com.blog.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "albuns")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "active")
    private Boolean active;

    @ManyToOne
    @JoinColumn(name="usu_creation", referencedColumnName="id")
    private User usuCriacao;

    @Column(name = "dataCriacao")
    private Date dataCreation;

    @Column(name = "name")
    private String name;

    public Album(Integer id){
        this.id = id;
    }

}
