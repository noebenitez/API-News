package com.utn.APINoticias.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@Entity
public class Video extends News{

    @NotEmpty(message = "'videoName' cannot be null or empty.")
    private String videoName;
    private String fileExt;  //FIle extension .mp4, .wmv ...

    @Override
    public TypeNews typeNews(){
        return TypeNews.VIDEO;
    }
}
