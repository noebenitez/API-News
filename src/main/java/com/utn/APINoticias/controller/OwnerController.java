package com.utn.APINoticias.controller;

import com.utn.APINoticias.model.Owner;
import com.utn.APINoticias.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    OwnerService ownerService;

    @GetMapping
    public List<Owner> getAll(@RequestParam(required = false) String name){
        return ownerService.getAll(name);
    }

    @GetMapping("/{id}")
    public Owner getOwnerById(@PathVariable Integer id){
        return ownerService.getById(id);
    }


    @PostMapping
    public void addOwner(@RequestBody Owner owner){
        ownerService.add(owner);
    }

    @PutMapping("/{id}")
    public Owner updateOwner(@PathVariable Integer id, @RequestBody Owner newOwner){
        Owner owner = ownerService.getById(id);
        owner.setName(newOwner.getName());
        owner.setLastname(newOwner.getLastname());
        owner.setNewsList(newOwner.getNewsList());
        ownerService.add(owner);
        return owner;
    }

    @DeleteMapping("{id}")
    public void deleteOwner(@PathVariable Integer id){
        ownerService.deleteById(id);
    }

    @PutMapping("/{id}/news/{idNews}")
    public void addNewsToOwner(@PathVariable Integer id, @PathVariable Integer idNews){
        ownerService.addNewsToOwner(id, idNews);
    }
    
}
