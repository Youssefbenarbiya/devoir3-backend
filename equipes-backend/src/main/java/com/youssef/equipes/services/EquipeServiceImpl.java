package com.youssef.equipes.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.youssef.equipes.entities.Equipe;
import com.youssef.equipes.entities.Image;
import com.youssef.equipes.entities.Ligue;
import com.youssef.equipes.repo.EquipeRepository;
import com.youssef.equipes.repo.ImageRepository;
import com.youssef.equipes.repo.LigueRepository;

@Service
public class EquipeServiceImpl implements EquipeService{
	@Autowired
	ImageRepository imageRepository;
	
	@Autowired
	EquipeRepository equipeRepository;
	
	
	@Autowired
	LigueRepository ligueRepository;
	
	@Override
	public Equipe saveEquipe(Equipe p) {
		return equipeRepository.save(p);
	}

	/*@Override
	public Equipe updateEquipe(Equipe p) {
		return equipeRepository.save(p);
	}*/
	@Override
	public Equipe updateEquipe(Equipe p) {
//	Long oldProdImageId = this.getEquipe(p.getIdEquipe()).getImage().getIdImage();
	//Long newProdImageId = p.getImage().getIdImage();
	Equipe prodUpdated = equipeRepository.save(p);
	//if (oldProdImageId != newProdImageId) //si l'image a été modifiée
//	imageRepository.deleteById(oldProdImageId);
	return prodUpdated;
	}
	@Override
	public void deleteEquipe(Equipe equipe) {
	    // Delete associated images from the database
	    List<Image> images = equipe.getImages();
	    for (Image image : images) {
	        imageRepository.delete(image);
	    }

	    // Finally, delete the Equipe
	    equipeRepository.delete(equipe);
	}

/*
	@Override
	public void deleteEquipeById(Long id) {
		equipeRepository.deleteById(id);		
	}*/
	@Override
	public void deleteEquipeById(Long id) {
	    Equipe equipe = equipeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Equipe not found"));

	    // Delete associated images from the database
	    List<Image> images = equipe.getImages();
	    for (Image image : images) {
	        imageRepository.delete(image);
	    }

	    // Finally, delete the Equipe
	    equipeRepository.deleteById(id);
	}


	@Override
	public Equipe getEquipe(Long id) {
		// TODO Auto-generated method stub
		return equipeRepository.findById(id).get();
	}

	@Override
	public List<Equipe> getAllEquipes() {
		// TODO Auto-generated method stub
		return equipeRepository.findAll();
	}
	@Override
	public Page<Equipe> getAllEquipesParPage(int page, int size) {
	return equipeRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Equipe> findByNomEquipe(String nom) {
		// TODO Auto-generated method stub
		return equipeRepository.findByNomEquipe(nom);
	}

	@Override
	public List<Equipe> findByNomEquipeContains(String nom) {
		return equipeRepository.findByNomEquipeContains(nom);
	}

	@Override
	public List<Equipe> findByNomRank(String nom, int rank) {
		return equipeRepository.findByNomRank(nom, rank);
	}
	@Override
	public List<Ligue> getAllLigues() {
		return  ligueRepository.findAll();
	}
	@Override
	public List<Equipe> findByLigue(Ligue ligue) {
		return equipeRepository.findByLigue(ligue);
	}

	@Override
	public List<Equipe> findByLigueId(Long id) {
	    return equipeRepository.findByLigueId(id);
	}


	@Override
	public List<Equipe> findByOrderByNomEquipeAsc() {
		return equipeRepository.findByOrderByNomEquipeAsc();
	}

	@Override
	public List<Equipe> trierEquipesNomsRank() {
		return equipeRepository.trierEquipesNomsRank();
	}

	@Override
	public Optional<Image> findById(Long equipeId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}


	
}
