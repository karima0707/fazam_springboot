package fr.fazam.entites;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name ="celebrite")
public class Celebrite {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int celebrit_id;
	
	
	@Column(name="nom")
	private String nom;
	@Column(name="prenom")
	private String prenom;

	@ManyToMany(mappedBy = "recherches")
	private Set<Utilisateur> utilisateurs= new HashSet<>();
	@ManyToMany(mappedBy = "celebriteVideo")
	private Set<Video> videos = new HashSet<>();
	public Celebrite() {
		super();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getCelebrit_id() {
		return celebrit_id;
	}

	public void setCelebrit_id(int celebrit_id) {
		this.celebrit_id = celebrit_id;
	}

	public Set<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(Set<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public Set<Video> getVideos() {
		return videos;
	}

	public void setVideos(Set<Video> videos) {
		this.videos = videos;
	}

	@Override
	public String toString() {
		return "Celebrite [celebrit_id=" + celebrit_id + ", nom=" + nom + ", prenom=" + prenom + ", utilisateurs="
				+ utilisateurs + ", videos=" + videos + "]";
	}


	}

	
	
	

