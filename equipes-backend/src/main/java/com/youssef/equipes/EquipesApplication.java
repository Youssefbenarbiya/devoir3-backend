package com.youssef.equipes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.youssef.equipes.entities.Equipe;
import com.youssef.equipes.entities.Ligue;



@SpringBootApplication
public class EquipesApplication implements CommandLineRunner {
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(EquipesApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {	
		repositoryRestConfiguration.exposeIdsFor(Equipe.class,Ligue.class);
	}
}
