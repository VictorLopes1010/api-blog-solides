package com.blog.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AlbumDTO {

    private Integer id;

    private String name;

    private Boolean active;

    private Integer usuCreationId;

}
