package fr.fazam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.fazam.entites.Video;

public interface VideoDao extends  JpaRepository <Video,Integer>{

}
