package fr.fazam.entites;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Utilisateur {
	@Id
	@GeneratedValue
	private String utilisateur_id;
	@Column(name="username")
	private String username;
	
	@Column(name="mail")
	private String mail;
	@ManyToMany(cascade =CascadeType.ALL)
	@JoinTable(name="Recherche",joinColumns = @JoinColumn(name = "utilisateur_id", referencedColumnName = "id"),
		       inverseJoinColumns = @JoinColumn(name = "celebrite_id", referencedColumnName = "id"))
	
	private Set<Celebrite> recherches;
    public Utilisateur() {
		super();
	}
	public Utilisateur(String username, String mail, Set<Celebrite> recherches) {
		super();
		
		this.username = username;
		this.mail = mail;
		this.recherches.addAll(recherches);
	}
	public Utilisateur(String username, String mail, Celebrite celebrite) {
		super();
		
		this.username = username;
		this.mail = mail;
		this.recherches.add(celebrite);
	}
	public String getUtilisateur_id() {
		return utilisateur_id;
	}
	public void setUtilisateur_id(String utilisateur_id) {
		this.utilisateur_id = utilisateur_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Set<Celebrite> getRecherches() {
		return recherches;
	}
	public void setRecherches(Set<Celebrite> recherches) {
		this.recherches = recherches;
	}
	@Override
	public String toString() {
		return "Utilisateur [utilisateur_id=" + utilisateur_id + ", username=" + username + ", mail=" + mail
				+ ", recherches=" + recherches + "]";
	} 
    
    
}