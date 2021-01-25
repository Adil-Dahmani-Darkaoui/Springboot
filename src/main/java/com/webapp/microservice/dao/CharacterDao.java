package com.webapp.microservice.dao;

import com.webapp.microservice.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface CharacterDao extends JpaRepository<Character, Integer> {

    List<Character> findAll();

    Character findById(int id);


//    void update(int id, Character character);
//
//    void delete(int id);


//    public List<Character> findAll();
//
//    public Character findById(int id);
//
//    public void save(Character character);
//
//    public void update(int id, Character character);
//
//    public void delete(int id);

}
