package fr.m2i.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name="comment")
public class Comment {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
private int _id;

@Basic
@Column(name="message")
private String message;


@ManyToOne
@JoinColumn(name = "id_news")
private News idNews;


@Basic
@Column(name="username")
private String username;


public int get_id() {
	return _id;
}


public void set_id(int _id) {
	this._id = _id;
}


public String getMessage() {
	return message;
}


public void setMessage(String message) {
	this.message = message;
}


public News getIdNews() {
	return idNews;
}


public void setIdNews(News idNews) {
	this.idNews = idNews;
}


public String getUsername() {
	return username;
}


public void setUsername(String username) {
	this.username = username;
}

/*
@ManyToOne
@JoinColumn(name = "id_user")
private UserLogin idUser;*/




}
