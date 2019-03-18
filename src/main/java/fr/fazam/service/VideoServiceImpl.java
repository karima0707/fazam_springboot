package fr.fazam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.fazam.dao.VideoDao;
import fr.fazam.entites.Video;

@Service
public class VideoServiceImpl implements VideoService {

	@Autowired
	VideoDao videoDao;
	
	
	@Override
	public List<Video> getAllVideos() {
		
		return videoDao.findAll();
	}

	@Override
	public boolean create(Video video) throws Exception {
		videoDao.save(video);
		return true;
	}

	@Override
	public boolean delete(int id) throws Exception {
		videoDao.delete(id);
		return true;
	}

}
