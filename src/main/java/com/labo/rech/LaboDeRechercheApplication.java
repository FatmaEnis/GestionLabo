package com.labo.rech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.labo.rech.entity.EnseignantChercheur;
import com.labo.rech.entity.Etudiant;
import com.labo.rech.entity.Membre;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@EnableJpaRepositories
public class LaboDeRechercheApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaboDeRechercheApplication.class, args);
		System.out.println("hello world");
		
		
	}

}
