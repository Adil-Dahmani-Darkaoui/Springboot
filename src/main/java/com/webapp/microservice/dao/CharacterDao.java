package com.webapp.microservice.dao;

import com.webapp.microservice.model.Character;

import java.util.List;

public interface CharacterDao {

    public List<Character> findAll();

    public Character findById(int id);

    public void save(Character character);

    public void update(int id, Character character);

    public void delete(int id);

}
