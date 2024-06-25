package com.unla.grupo03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import com.unla.grupo03.model.Product;
import com.unla.grupo03.repository.ProductRepository;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class Grupo03Application   implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Grupo03Application.class, args);
	}
	
	@Autowired
	ProductRepository repositorio;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*Product producto1 = new Product("Sacapuntas", "Sacapuntas rojo", (double)35,5,3);
		repositorio.save(producto1);
		
		
		Product producto2 = new Product("Sacapuntas", "Sacapuntas rojo", (double)35,22,3);
		repositorio.save(producto2);
		Product producto3 = new Product("Caruchera", "Caruchera verde",  (double)200,5,6);
		repositorio.save(producto3);
	*/
		}

}
