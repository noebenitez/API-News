package com.utn.APINoticias.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.time.LocalTime;

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
    private Integer id;
    private String title;
    private LocalTime date;
    private String category;    //Business, science, etc.

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

    public LocalTime getDate() {
        return date;
    }

    public void setDate(LocalTime date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
