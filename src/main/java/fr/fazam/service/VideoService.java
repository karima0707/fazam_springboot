package fr.fazam.service;

import java.util.List;

import fr.fazam.entites.Video;



public interface VideoService {
	
	public List<Video> getAllVideos();
	public boolean create(Video video) throws Exception;
	public boolean delete(int id) throws Exception;

}
