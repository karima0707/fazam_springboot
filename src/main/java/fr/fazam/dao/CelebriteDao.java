package fr.fazam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.fazam.entites.Celebrite;
public interface CelebriteDao extends JpaRepository<Celebrite,Integer> {

}
