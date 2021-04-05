package com.utn.APINoticias.controller;

import com.utn.APINoticias.model.News;
import com.utn.APINoticias.model.Owner;
import com.utn.APINoticias.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @PostMapping
    public void addNews(@RequestBody News news){
        newsService.addNews(news);
    }


    @DeleteMapping("/news/{id}")
    public void deleteNews(@PathVariable Integer id){
        newsService.deleteById(id);
    }
}
