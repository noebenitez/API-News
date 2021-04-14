package com.utn.APINoticias.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Owner {    //News' autor

    @Id
    @GeneratedValue
    private Integer id;

    @NotEmpty(message = "'Name' cannot be null or empty.")
    private String name;

    @NotEmpty(message = "'Lastname' cannot be null or empty.")
    private String lastname;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "news_id")
    List<News> newsList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }
}
