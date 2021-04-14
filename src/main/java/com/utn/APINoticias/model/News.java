package com.utn.APINoticias.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "typeNews", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Image.class, name = "IMAGE"),
        @JsonSubTypes.Type(value = Video.class, name = "VIDEO"),
        @JsonSubTypes.Type(value = Text.class, name = "TEXT")
})

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class News {
    @Id
    @GeneratedValue
    private Integer id;

    @NotEmpty(message = "'title' cannot be null or empty.")
    private String title;

    private LocalDate date;

    @NotEmpty(message = "'category' cannot be null or empty.")
    private String category;    //Business, science, etc.

    @NotEmpty(message = "'typeNews' cannot be null or empty.")
    @AccessType(AccessType.Type.PROPERTY)
    public abstract TypeNews typeNews();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
