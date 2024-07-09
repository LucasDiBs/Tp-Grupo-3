package com.unla.grupo03.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter 
@Setter
@ToString
@NoArgsConstructor

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="nombre", nullable=false, length=45)
	private String nombre;
	
	@Column(name="apellido", nullable=false, length=45)
	private String apellido;
	
	@Column(name="email", unique=true, nullable=false, length=45)
	private String email;

	@Column(name="password", nullable=false, length=60)
	private String password;	

	@OneToMany(fetch=FetchType.EAGER, mappedBy="user", cascade = {CascadeType.ALL})
	private Set<UserRol> userRoles = new HashSet<>();
	
	public User(String nombre, String apellido, String email, String password, Set<UserRol> userRoles) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.userRoles = userRoles;
	}	
	
	public User(String nombre, String apellido, String email, String password) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
	}
	
	public void addRol(UserRol rol) {
		
		userRoles.add(rol);
	}

	public String getPassword() {
		
		return this.password;
	}
	
	public String getEmail() {
		return this.email;
	}


	public void setPassword(String encode) {
		this.password = encode;		
	}

	public Set<UserRol> getUserRoles() {
		return this.userRoles;
	}
	
	//retorna el rol asociado como string
	public String rolPrincipal() {
		
		List<String> roles = new ArrayList<String>();
		
		for (UserRol r: this.userRoles) {
			roles.add(r.getRol());
		}
		
		return roles.get(0);
	}
	

	
}