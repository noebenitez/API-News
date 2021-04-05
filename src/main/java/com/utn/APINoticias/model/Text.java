package com.utn.APINoticias.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity

public class Text extends News{

    private Integer totalWords;     //Amount of words

    @Override
    public TypeNews typeNews() {
        return TypeNews.TEXT;
    }
}
