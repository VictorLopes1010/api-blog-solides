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
@Table(name = "post_comments")
public class PostComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="id_post", referencedColumnName="id")
    private Post post;

    @Column(name = "information")
    private String information;

    @Column(name = "active")
    private Boolean active;

    @ManyToOne
    @JoinColumn(name="usu_creation", referencedColumnName="id")
    private User usuCriacao;

    @Column(name = "date_creation")
    private Date dateCreation;

}
