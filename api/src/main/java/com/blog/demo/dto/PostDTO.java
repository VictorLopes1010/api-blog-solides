package com.blog.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    private Integer id;

    private String information;

    private Boolean active;

    private String link;

    private Integer usuCreationId;
    
    public PostDTO(PostInterfaceDTO x){
        this.id = x.getId();
        this.information = x.getInformation();
        this.active = x.getActive();
        this.link = x.getLink();
        this.usuCreationId = x.getUsuCreationId();
    }
    
    public interface PostInterfaceDTO{

        Integer getId();

        String getInformation();

        Boolean getActive();

        String getLink();

        Integer getUsuCreationId();
    }

}
