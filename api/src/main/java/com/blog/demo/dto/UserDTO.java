package com.blog.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Integer id;

    private String name;

    private String email;
    
    public UserDTO(UserInterfaceDTO x){
        this.id = x.getId();
        this.name = x.getName();
        this.email = x.getEmail();
    }
    
    public interface UserInterfaceDTO{

        Integer getId();

        String getName();

        String getEmail();
    }

}
