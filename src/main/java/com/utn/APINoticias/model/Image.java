package com.utn.APINoticias.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@Entity

public class Image extends News{

    @NotEmpty(message = "'imageName' cannot be null or empty.")
    private String imageName;

    @Size(min = 2, max = 6, message = "File extension must be between 2 and 6 characters.")
    private String fileExt;     //file extension .jpg, .png ...

    @Override
    public TypeNews typeNews() {
        return TypeNews.IMAGE;
    }
}
