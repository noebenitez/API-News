package com.utn.APINoticias.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
@Entity

public class Text extends News{

    @Min(value = 1, message = "The text must have at least 1 word.")
    private Integer totalWords;     //Amount of words

    @Override
    public TypeNews typeNews() {
        return TypeNews.TEXT;
    }
}
