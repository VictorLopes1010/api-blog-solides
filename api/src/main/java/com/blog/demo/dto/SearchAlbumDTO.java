package com.blog.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SearchAlbumDTO {

    private Integer id;

    private String name;

    private String nameCreator;
    
    public SearchAlbumDTO(SearchAlbumInterfaceDTO x){
        this.id = x.getId();
        this.name = x.getName();
        this.nameCreator = x.getNameCreator();
    }

    public interface SearchAlbumInterfaceDTO{

        Integer getId();

        String getName();

        String getNameCreator();
    }
}
