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


import fr.fazam.entites.Utilisateur;
import fr.fazam.service.UtilisateurService;


@RestController
@RequestMapping("utilisateurs")
public class UtilisateurController {
	@Autowired
	 private UtilisateurService utilisateurService;
	
	@GetMapping()
	public ResponseEntity<List<Utilisateur>> getAllUtilisateurs() {
		List<Utilisateur> list = utilisateurService.getAllUsers();
		return new ResponseEntity<List<Utilisateur>>(list, HttpStatus.OK);
	}
	
	
	@PostMapping()
	public ResponseEntity<Void> addUtilisateur(@RequestBody Utilisateur utilisateur, UriComponentsBuilder builder) throws Exception {
		boolean flag = utilisateurService.create(utilisateur);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/utilisateur/{id}").buildAndExpand(utilisateur.getUtilisateur_id()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUtilisateur(@PathVariable("id") Integer id) throws Exception {
		boolean flag = utilisateurService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	 @GetMapping("/search/{id}") public ResponseEntity<Utilisateur> getUtilisateur(@PathVariable("id") Integer
	  id)  { Utilisateur user = utilisateurService.findById(id); return
	  new ResponseEntity<Utilisateur> (user, HttpStatus.OK); } 
	 
}