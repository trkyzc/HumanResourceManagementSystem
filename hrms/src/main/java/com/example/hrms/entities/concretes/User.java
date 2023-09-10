package com.example.hrms.entities.concretes;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Entity
@Data
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User  {
	
	public User() {};
	
	@Id
	@GeneratedValue
	@Column(name="id")
	@JsonIgnore                   //json gösteriminin dışında tutar.
	private int id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Transient                        //özelliği veritabanının dışında tutar.
	private String repeatedPassword;
	
	
}
