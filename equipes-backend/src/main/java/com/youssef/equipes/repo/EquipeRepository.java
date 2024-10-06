package com.youssef.equipes.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.youssef.equipes.entities.Equipe;
import com.youssef.equipes.entities.Ligue;

@RepositoryRestResource(path = "rest")
public interface EquipeRepository extends JpaRepository<Equipe, Long> {
	List<Equipe> findByNomEquipe(String nom);
	List<Equipe> findByNomEquipeContains(String nom);
	
	//@Query("select p from Equipe p where p.nomEquipe like %?1 and p.rankEquipe > ?2")
	//List<Equipe> findByNomRank (String nom, int rank);
	
	@Query("select p from Equipe p where p.nomEquipe like %:nom and p.rankEquipe > :rank")
	List<Equipe> findByNomRank (@Param("nom") String nom,@Param("rank") int rank);
	
	@Query("select p from Equipe p where p.ligue = ?1")
	List<Equipe> findByLigue(Ligue ligue);
	
	@Query("select e from Equipe e where e.ligue.idLigue = :id")
	List<Equipe> findByLigueId(@Param("id") Long id);


	List<Equipe> findByOrderByNomEquipeAsc();
	
	@Query("select p from Equipe p order by p.nomEquipe ASC, p.rankEquipe DESC")
	List<Equipe> trierEquipesNomsRank();
}
