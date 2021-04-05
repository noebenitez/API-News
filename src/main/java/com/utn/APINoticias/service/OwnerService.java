package com.utn.APINoticias.service;

import com.utn.APINoticias.model.News;
import com.utn.APINoticias.model.Owner;
import com.utn.APINoticias.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class OwnerService {

    private OwnerRepository ownerRepository;
    private NewsService newsService;

    @Autowired

    public OwnerService(OwnerRepository ownerRepository, NewsService newsService) {
        this.ownerRepository = ownerRepository;
        this.newsService = newsService;
    }

    public List<Owner> getAll(){
        return ownerRepository.findAll();
    }

    public void add(Owner owner){
        ownerRepository.save(owner);
    }

    public Owner getById(Integer id){
        return ownerRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public void deleteById(Integer id){
        ownerRepository.deleteById(id);
    }

    public void addNewsToOwner(Integer idOwner, Integer idNews){
        Owner owner = getById(idOwner);
        News news = newsService.getById(idNews);
        owner.getNewsList().add(news);
        ownerRepository.save(owner);
    }
}
