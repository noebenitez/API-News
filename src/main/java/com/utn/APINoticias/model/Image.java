package com.utn.APINoticias.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity

public class Image extends News{

    private String imageName;
    private String fileExt;     //file extension .jpg, .png ...

    @Override
    public TypeNews typeNews() {
        return TypeNews.IMAGE;
    }
}
