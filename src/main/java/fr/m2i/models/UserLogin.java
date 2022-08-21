package fr.m2i.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class UserLogin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Basic
	@Column(name="prenom")
	private String prenom;
	@Basic
	@Column(name="nom")
	private String nom;
	@Basic
	@Column(name="username")
	private String username;
	@Basic
	@Column(name="password")
	private String psw;
	@Basic
	@Column(name="admin")
	private boolean admin;
	/*
	@OneToMany(targetEntity = Comment.class, mappedBy= "idUser")
	private List<Comment> _comments = new ArrayList<>();*/

	
	//Constructeur
	public UserLogin() {	
	}
	
	public UserLogin(String prenom, String nom, String username, String psw, boolean a) {
		this.setPrenom(prenom);
		this.setNom(nom);
		this.setUsername(username);
		this.setPsw(psw);
		this.setAdmin(a);
	}
	
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}