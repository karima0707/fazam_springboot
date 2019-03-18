package fr.fazam.service;

import java.util.List;

import fr.fazam.entites.Celebrite;



public interface CelebriteService {
	
	public List<Celebrite> getAllCelebrites();
	public boolean create(Celebrite celebrite) throws Exception;
	public boolean delete(int id) throws Exception;
}
