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



import fr.fazam.entites.Celebrite;

import fr.fazam.service.CelebriteService;

@RestController
@RequestMapping("celebrites")
public class CelebriteController {

	
	@Autowired
	 private CelebriteService celebriteService;
	
	@GetMapping()
	public ResponseEntity<List<Celebrite>> getAllCelebrites() {
		List<Celebrite> list = celebriteService.getAllCelebrites();
		return new ResponseEntity<List<Celebrite>>(list, HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Void> addCelebrite(@RequestBody Celebrite celebrite, UriComponentsBuilder builder) throws Exception {
		boolean flag = celebriteService.create(celebrite);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/celebrite/{id}").buildAndExpand(celebrite.getCelebrit_id()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable("id") Integer id) throws Exception {
		boolean flag = celebriteService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	 @GetMapping("/search/{id}") public ResponseEntity<Celebrite> getCelerite(@PathVariable("id") Integer
	  id)  { Celebrite celebrite = celebriteService.findById(id); 
	  return
	  new ResponseEntity<Celebrite> (celebrite, HttpStatus.OK); } 
}
