package fr.fazam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.fazam.dao.UtilisateurDao;
import fr.fazam.entites.Utilisateur;
@Service
public class UtilisateurServiceImpl implements UtilisateurService{

	
	@Autowired
	UtilisateurDao utilisateurDao;
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

}
