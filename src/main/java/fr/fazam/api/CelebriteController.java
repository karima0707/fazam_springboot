package fr.fazam.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import fr.fazam.entites.Celebrite;
import fr.fazam.service.CelebriteService;

@RestController
@RequestMapping("celebrite")
public class CelebriteController {

	
	@Autowired
	 private CelebriteService celebriteService;
	
	@GetMapping("celebrites")
	public ResponseEntity<List<Celebrite>> getAllCelebrites() {
		List<Celebrite> list = celebriteService.getAllCelebrites();
		return new ResponseEntity<List<Celebrite>>(list, HttpStatus.OK);
	}
	
	
}
