package com.youssef.equipes.services;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.youssef.equipes.entities.Equipe;
import com.youssef.equipes.entities.Image;
import com.youssef.equipes.entities.Ligue;
public interface EquipeService {
	Equipe saveEquipe(Equipe p);
	Equipe updateEquipe(Equipe p);
	void deleteEquipe(Equipe p);
	void deleteEquipeById(Long id);
	Equipe getEquipe(Long id);
	List<Equipe> getAllEquipes();
	Page<Equipe> getAllEquipesParPage(int page, int size);
	List<Ligue> getAllLigues();
	List<Equipe> findByNomEquipe(String nom);
	List<Equipe> findByNomEquipeContains(String nom);
	List<Equipe> findByNomRank (String nom, int rank);
	List<Equipe> findByLigue (Ligue ligue);
	List<Equipe> findByLigueId(Long ligueId);
	List<Equipe> findByOrderByNomEquipeAsc();
	List<Equipe> trierEquipesNomsRank();
	Optional<Image> findById(Long equipeId);
	


	
}




