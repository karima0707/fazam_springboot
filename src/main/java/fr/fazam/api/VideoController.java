package fr.fazam.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


import fr.fazam.entites.Video;

import fr.fazam.service.VideoService;

@RestController
@RequestMapping("video")
public class VideoController {
	
	@Autowired
	 private VideoService videoService;
	
	@GetMapping("videos")
	public ResponseEntity<List<Video>> getAllVideos() {
		List<Video> list = videoService.getAllVideos();
		return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
	}
	
	@PostMapping("video")
	public ResponseEntity<Void> addVideo(@RequestBody Video video, UriComponentsBuilder builder) throws Exception {
		boolean flag = videoService.create(video);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/video/{id}").buildAndExpand(video.getVideo_id()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@DeleteMapping("video/{id}")
	public ResponseEntity<Void> deleteVideo(@PathVariable("id") Integer id) throws Exception {
		boolean flag = videoService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
