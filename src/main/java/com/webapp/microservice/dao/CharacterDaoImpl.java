package com.webapp.microservice.dao;

import com.webapp.microservice.model.Character;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CharacterDaoImpl implements CharacterDao {

    public static List<Character> characters = new ArrayList<>();

    @Override
    public List<Character> findAll() {
        ArrayList<Character> characterList = new ArrayList<>();
        try {
            Connection con = JDBCConnection.getInstance();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from personnages");

            while (rs.next()) {
                Character character = new Character(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("type"));
                characterList.add(character);
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return characterList;
    }

    @Override
    public Character findById(int id){
        Character character = new Character();
        try {
            Connection con = JDBCConnection.getInstance();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from personnages where id ="+id);

            while (rs.next()) {
                character.setId(rs.getInt("id"));
                character.setName(rs.getString("name"));
                character.setType(rs.getString("type"));
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return character;
    }

//    @Override
//    public Character findById(int id) {
//
//        for (Character character : characters) {
//            if (character.getId() == id) {
//                return character;
//            }
//        }
//        return null;
//    }

    @Override
    public void save(Character character) {

        characters.add(character);
    }

    @Override
    public void update(int id, Character character) {

        for (Character updateCharacter : characters) {
            if (updateCharacter.getId() == id) {
                updateCharacter.setId(character.getId());
                updateCharacter.setName(character.getName());
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
