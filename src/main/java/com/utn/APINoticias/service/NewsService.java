package com.utn.APINoticias.service;

import com.utn.APINoticias.model.News;
import com.utn.APINoticias.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    NewsRepository newsRepository;

    public void addNews(News n){
        newsRepository.save(n);
    }

    public void deleteById(Integer id){
        newsRepository.deleteById(id);
    }

    public News getById(Integer id){
        return newsRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }
}
