package com.webapp.microservice.controller;


import com.webapp.microservice.dao.CharacterDao;
import com.webapp.microservice.model.Character;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags ={"Gestion des personnages"},description = "Créer, afficher, modifier et supprimer des personnages")
@RestController
public class CharacterController {

    @Autowired
    private CharacterDao characterDao;

    //Get Characters
    @ApiOperation(value = "Retourne la liste des personnages")
    @GetMapping(value = "/Characters")
    public List<Character> CharactersList(){
        return characterDao.findAll();
    }

    //Get Characters/{id}
    @ApiOperation(value = "Retourne les infos d'un personnage")
    @GetMapping(value = "/Characters/{id}")
    public Character displayCharacter(@PathVariable int id) {
        return characterDao.findById(id);
    }

    //Post Characters
    @ApiOperation(value = "Ajoute un personnage")
    @PostMapping(value = "/Characters")
    public void addCharacter(@RequestBody Character character){
        characterDao.save(character);
    }

    //Put Characters/{id}
    @ApiOperation(value = "Modifie un personnage")
    @PutMapping(value = "/Characters/{id}")
    public void updateCharacter(@PathVariable int id, @RequestBody Character character){
        characterDao.update(id, character);
    }

    //Delete Characters/{id}
    @ApiOperation(value = "Supprime un personnage")
    @DeleteMapping(value = "/Characters/{id}")
    public void deleteCharacter(@PathVariable int id){
        characterDao.delete(id);
    }
}
