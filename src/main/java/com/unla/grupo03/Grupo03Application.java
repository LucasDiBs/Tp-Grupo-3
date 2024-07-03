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
public class Grupo03Application {

	public static void main(String[] args) {
		SpringApplication.run(Grupo03Application.class, args);
	}
}

