package com.youssef.equipes.RESTControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.youssef.equipes.entities.Equipe;
import com.youssef.equipes.services.EquipeService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class EquipeRESTController {
	
	@Autowired
	EquipeService equipeService;
	
	@RequestMapping(path="all",method = RequestMethod.GET)
	public List<Equipe> getAllEquipes() {
	return equipeService.getAllEquipes();
	}
	@RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
	public Equipe getEquipeById(@PathVariable("id") Long id) {
	return equipeService.getEquipe(id);
	}
	@RequestMapping(path="/addeqip",method = RequestMethod.POST)
	//@PreAuthorize("hasAuthority('ADMIN')")
	public Equipe createEquipe(@RequestBody Equipe equipe) {
	return equipeService.saveEquipe(equipe);
	}
	@RequestMapping(path="/updateeqip",method = RequestMethod.PUT)
	public Equipe updateEquipe(@RequestBody Equipe equipe) {
	return equipeService.updateEquipe(equipe);
	}
	
	@RequestMapping(value="/deleqip/{id}",method = RequestMethod.DELETE)
	public void deleteEquipe(@PathVariable("id") Long id)
	{
	equipeService.deleteEquipeById(id);
	}
	@RequestMapping(value="/equipeLig/{idLigue}",method = RequestMethod.GET)
	public List<Equipe> getEquipesByCatId(@PathVariable("idLigue") Long idCat) {
	return equipeService.findByLigueId(idCat);
	}
	
	@RequestMapping(value="/eqipsByName/{nom}",method = RequestMethod.GET)
	public List<Equipe> findByNomEquipeContains(@PathVariable("nom") String nom) {
	return equipeService.findByNomEquipeContains(nom);
	}
}
