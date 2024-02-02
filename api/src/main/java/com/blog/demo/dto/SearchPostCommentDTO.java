package com.blog.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SearchPostCommentDTO {

    private String information;

    private String creatorName;
    
    public SearchPostCommentDTO(SearchPostCommentInterfaceDTO x){
        this.information = x.getInformation();
        this.creatorName = x.getCreatorName();
    }
    
    public interface SearchPostCommentInterfaceDTO{

        String getInformation();

        String getCreatorName();
    }

}
