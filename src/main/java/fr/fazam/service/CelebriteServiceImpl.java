package fr.fazam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.fazam.dao.CelebriteDao;
import fr.fazam.entites.Celebrite;


@Service
public class CelebriteServiceImpl implements CelebriteService {

	
	@Autowired
	CelebriteDao celebriteDao;
	@Override
	public List<Celebrite> getAllCelebrites() {
		// TODO Auto-generated method stub
		return celebriteDao.findAll();
	}

	@Override
	public boolean create(Celebrite celebrite) throws Exception {
		// TODO Auto-generated method stub
		celebriteDao.save(celebrite);
		return true;
	}

	@Override
	public boolean delete(int id) throws Exception {
		celebriteDao.delete(id);
		return false;
	}

}
