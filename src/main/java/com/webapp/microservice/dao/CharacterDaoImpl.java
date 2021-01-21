package com.webapp.microservice.dao;

import com.webapp.microservice.model.Character;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CharacterDaoImpl implements CharacterDao {

    public static List<Character> characters = new ArrayList<>();

    static {
        characters.add(new Character(1, new String("Gandalf"), new String("Mage")));
        characters.add(new Character(2, new String("Aragorn"), new String("Warrior")));
        characters.add(new Character(2, new String("Sarouman"), new String("Mage")));
        characters.add(new Character(2, new String("Boromir"), new String("Warrior")));
    }

    @Override
    public List<Character> findAll() {
        return characters;
    }

    @Override
    public Character findById(int id) {

        for (Character character : characters) {
            if (character.getId() == id) {
                return character;
            }
        }
        return null;
    }

    @Override
    public void save(Character character) {

        characters.add(character);
    }

    @Override
    public void update(int id, Character character) {

        for (Character updateCharacter : characters) {
            if (updateCharacter.getId() == id) {
                updateCharacter.setId(character.getId());
                updateCharacter.setNom(character.getNom());
                updateCharacter.setType(character.getType());
                return;
            }
        }
    }

    @Override
    public void delete(int id) {

        characters.removeIf(character -> character.getId() == id);
    }
}
