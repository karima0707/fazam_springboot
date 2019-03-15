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
public class Video {
	
	@Id
	@GeneratedValue
	private String video_id;
	@Column(name="titre")
	private String titre;
	@Column(name="annee")
	private String annee;
	@Column(name="film")
	private boolean film;
	@ManyToMany(cascade =CascadeType.ALL)
	@JoinTable(name="celebrite_has_video",joinColumns = @JoinColumn(name = "video_id", referencedColumnName = "id"),
		       inverseJoinColumns = @JoinColumn(name = "celebrite_id", referencedColumnName = "id"))
	private Set<Celebrite> celebriteVideo;
	public Video() {
		super();
	}
	public Video(String titre, String annee, boolean film, Set<Celebrite> celebriteVideo) {
		super();
		this.titre = titre;
		this.annee = annee;
		this.film = film;
		this.celebriteVideo.addAll(celebriteVideo);
	}
	
	public Video(String titre, String annee, boolean film,Celebrite celebrite) {
		super();
		this.titre = titre;
		this.annee = annee;
		this.film = film;
		this.celebriteVideo.add(celebrite);
	}
	public String getVideo_id() {
		return video_id;
	}
	public void setVideo_id(String video_id) {
		this.video_id = video_id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAnnee() {
		return annee;
	}
	public void setAnnee(String annee) {
		this.annee = annee;
	}
	public boolean isFilm() {
		return film;
	}
	@Override
	public String toString() {
		return "Video [video_id=" + video_id + ", titre=" + titre + ", annee=" + annee + ", film=" + film
				+ ", celebriteVideo=" + celebriteVideo + "]";
	}
	public void setFilm(boolean film) {
		this.film = film;
	}
	public Set<Celebrite> getCelebriteVideo() {
		return celebriteVideo;
	}
	public void setCelebriteVideo(Set<Celebrite> celebriteVideo) {
		this.celebriteVideo = celebriteVideo;
	}
	
}
