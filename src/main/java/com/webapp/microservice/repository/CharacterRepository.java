package com.webapp.microservice.repository;

import com.webapp.microservice.model.Character;
import org.hibernate.type.StringType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {
//   List<Character> findAllByType(String type);
}
