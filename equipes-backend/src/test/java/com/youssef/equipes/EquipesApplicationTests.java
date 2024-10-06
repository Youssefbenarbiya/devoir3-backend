package com.youssef.equipes;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.youssef.equipes.entities.Equipe;
import com.youssef.equipes.entities.Ligue;
import com.youssef.equipes.repo.EquipeRepository;
import com.youssef.equipes.services.EquipeService;

@SpringBootTest
class EquipesApplicationTests {
	@Autowired
	private EquipeService equipeService;
	@Autowired
	private EquipeRepository equipeRepository;
	/*@Test
	public void testCreateEquipe() {
		Equipe equip = new Equipe("Bercelone",5,new Date());
		equipeRepository.save(equip);
	}*/
	@Test
	public void testFindEquipe()
	{
	Equipe p = equipeRepository.findById(6L).get();
	System.out.println(p);
	}
	 @Test
	public void testUpdateEquipe()
	{
	Equipe p = equipeRepository.findById(12L).get();
	p.setRankEquipe(100);
	equipeRepository.save(p);
	} 
	@Test
	public void testDeleteEquipe()
	{
	equipeRepository.deleteById(10L);;
	}
	@Test
	public void testListerTousEquipes()
	{
	List<Equipe> prods = equipeRepository.findAll();
	for (Equipe p : prods)
	{
	System.out.println(p);
	}
	}
	@Test
	public void testFindByNomEquipeContains()
	{
	Page<Equipe> prods = equipeService.getAllEquipesParPage(0,2);
	System.out.println(prods.getSize());
	System.out.println(prods.getTotalElements());
	System.out.println(prods.getTotalPages());
	prods.getContent().forEach(p -> {System.out.println(p.toString());
	});
	/*ou bien
	for (Equipe p : prods)
	{
	System.out.println(p);
	} */
	}
	@Test
	public void testFindByNomEquipe()
	{
	List<Equipe> prods = equipeRepository.findByNomEquipe("Real madrid");
	for (Equipe p : prods)
	{
	System.out.println(p);
	}
	}
	
	@Test
	public void testfindByNomRank()
	{
	List<Equipe> prods = equipeRepository.findByNomRank("Real madrid", 2);
	for (Equipe p : prods)
	{
	System.out.println(p);
	}
	}
	
	@Test
	public void testfindByLigue()
	{
		Ligue lig = new Ligue(null, null, null);
		lig.setIdLigue(12L);
	List<Equipe> prods = equipeRepository.findByLigue(lig);
	for (Equipe p : prods)
	{
	System.out.println(p);
	}
	}
	@Test
	public void testfindByOrderByNomEquipeAsc()
	{
	List<Equipe> prods =
			equipeRepository.findByOrderByNomEquipeAsc();
	for (Equipe p : prods)
	{
	System.out.println(p);
	}
	}
	@Test
	public void trierEquipesNomsRank()
	{
	List<Equipe> prods = equipeRepository.trierEquipesNomsRank();
	for (Equipe p : prods)
	{
	System.out.println(p);
	}
	}

}
