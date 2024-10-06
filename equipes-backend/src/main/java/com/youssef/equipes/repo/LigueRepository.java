package com.youssef.equipes.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.youssef.equipes.entities.Ligue;

@RepositoryRestResource(path = "ligue") 
@CrossOrigin("http://localhost:4200/") 
public interface LigueRepository extends JpaRepository<Ligue, Long>{

}
