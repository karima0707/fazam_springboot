package fr.fazam.service;

import java.util.List;



import fr.fazam.entites.Utilisateur;

public interface UtilisateurService {
	
	public boolean create(Utilisateur utilisateur) throws Exception;
	public List<Utilisateur> getAllUsers();
	public boolean delete(int id) throws Exception;

}
