package fr.fazam.entites;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "utilisateur")
public class Utilisateur implements Serializable, UserDetails {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int utilisateur_id;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;

	@Column(name = "mail")
	private String mail;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Recherche", joinColumns = @JoinColumn(name = "utilisateur_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "celebrite_id", referencedColumnName = "id"))

	private Set<Celebrite> recherches;

	public Utilisateur() {
		super();
	}

	public Utilisateur(String username, String password, String mail, Set<Celebrite> recherches) {
		super();

		this.username = username;
		this.password = password;
		this.mail = mail;
		this.recherches.addAll(recherches);
	}

	public Utilisateur(String username, String password, String mail, Celebrite celebrite) {
		super();

		this.username = username;
		this.password = password;
		this.mail = mail;
		this.recherches.add(celebrite);
	}

	public int getUtilisateur_id() {
		return utilisateur_id;
	}

	public void setUtilisateur_id(int utilisateur_id) {
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}