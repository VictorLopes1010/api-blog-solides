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
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "information")
    private String information;

    @Column(name = "link")
    private String link;

    @Column(name = "active")
    private Boolean active;

    @ManyToOne
    @JoinColumn(name="usu_creation", referencedColumnName="id")
    private User usuCriacao;

    @Column(name = "date_creation")
    private Date dataCreation;

    @Column(name = "name")
    private String name;


    public Post(Integer id){
        this.id = id;
    }

}
