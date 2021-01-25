package com.webapp.microservice.controller;


import com.webapp.microservice.model.Character;
import com.webapp.microservice.repository.CharacterRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;

@Api(tags ={"Gestion des personnages"},description = "Créer, afficher, modifier et supprimer des personnages")
@RestController
public class CharacterController {

    @Autowired
    private CharacterRepository characterRepository;

//    //Get Characters
//    @ApiOperation(value = "Retourne la liste des personnages")
//    @GetMapping(value = "/Characters")
//    public @ResponseBody //Renvoi une liste de Character qui se trouve dans le body de la réponse json
//    Iterable<Character> getAllCharacters() {
//        return characterRepository.findAll();
//    }

    //Get Characters
    @ApiOperation(value = "Retourne la liste des personnages")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = Character.class))),
//            @ApiResponse(responseCode = "400", description = "Invalid input"),
//            @ApiResponse(responseCode = "404", description = "Not Found") })
    @GetMapping(value = "/Character")
    public ArrayList<Character> characterList(){
        return (ArrayList<Character>) characterRepository.findAll();
}

//    //Get Characters/{id}
//    @ApiOperation(value = "Retourne les infos d'un personnage")
//    @GetMapping(value = "/Characters/{id}")
//    public Character displayCharacter(@PathVariable int id) {
//        return characterDao.findById(id);
//    }
//
//    //Post Characters
//    @ApiOperation(value = "Ajoute un personnage")
//    @PostMapping(value = "/Characters")
//    public void addCharacter(@RequestBody Character character){
//        characterDao.save(character);
//    }

//    //Put Characters/{id}
//    @ApiOperation(value = "Modifie un personnage")
//    @PutMapping(value = "/Characters/{id}")
//    public void updateCharacter(@PathVariable int id, @RequestBody Character character){
//        characterDao.update(id, character);
//    }
//
//    //Delete Characters/{id}
//    @ApiOperation(value = "Supprime un personnage")
//    @DeleteMapping(value = "/Characters/{id}")
//    public void deleteCharacter(@PathVariable int id){
//        characterDao.delete(id);
//    }
}
