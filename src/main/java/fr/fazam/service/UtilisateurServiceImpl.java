package fr.fazam.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.fazam.dao.UtilisateurDao;
import fr.fazam.entites.Utilisateur;
@Service
public class UtilisateurServiceImpl implements UtilisateurService{

	
	
	UtilisateurDao utilisateurDao;
	
	 @Autowired
	    public UtilisateurServiceImpl(UtilisateurDao utilisateurDao) {
	        this.utilisateurDao=utilisateurDao;
	    }
	@Override
	public boolean create(Utilisateur utilisateur) throws Exception {
		utilisateurDao.save(utilisateur);
		return true;
	}

	@Override
	public List<Utilisateur> getAllUsers() {
		// TODO Auto-generated method stub
		return utilisateurDao.findAll();
	}

	@Override
	public boolean delete(int id) throws Exception {
		utilisateurDao.delete(id);
		return true;
	}
	
	
	/*
	 * public Utilisateur findByUsername(String username) { Utilisateur user =
	 * utilisateurDao.findUserWithName(username); if (user == null) { throw new
	 * UsernameNotFoundException("No user present with username : " + username); }
	 * else { return user;
	 * 
	 * }
	 * 
	 * }
	 */
}
