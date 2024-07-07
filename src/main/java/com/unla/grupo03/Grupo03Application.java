package com.unla.grupo03;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.core.userdetails.User;

import com.unla.grupo03.model.Product;
import com.unla.grupo03.model.UserRol;
import com.unla.grupo03.repository.ProductRepository;
import com.unla.grupo03.repository.UserRepository;
import com.unla.grupo03.service.UserService;
import com.unla.grupo03.service.UserServiceImpl;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class Grupo03Application implements CommandLineRunner  {


	public static void main(String[] args) {
		SpringApplication.run(Grupo03Application.class, args);
	}

	@Autowired
	ProductRepository repositorio;
	@Autowired
	UserServiceImpl uService;


	@Override
	public void run(String... args) throws Exception {
			
			/*
			Product producto1 = new Product("Sacapuntas", "Sacapuntas Rojo", (double)35,(double)20,5,3);
			repositorio.save(producto1);
			
			Product producto2 = new Product("Sacapuntas", "Sacapuntas Verde", (double)35,(double)20,22,3);
			repositorio.save(producto2);
			
			Product producto3 = new Product("Cartuchera", "Caruchera Verde",  (double)200,(double)100,5,6);
			repositorio.save(producto3);
			
			Product producto4 = new Product("Cartuchera", "Caruchera Roja",  (double)200,(double)100,5,6);
			repositorio.save(producto4);
			
			Product producto5 = new Product("Mochila", "Mochila Grande",  (double)500,(double)250,10,3);
			repositorio.save(producto4);
			
			
			com.unla.grupo03.model.User admin = new com.unla.grupo03.model.User("Admin", "Admin","admin@admin","1234");
			
			
			
			uService.createAdmin(admin);		
			
			com.unla.grupo03.model.User user = new com.unla.grupo03.model.User("User", "User","user@user","1234");
			
			uService.createUser(user);
		*/
	}
}



