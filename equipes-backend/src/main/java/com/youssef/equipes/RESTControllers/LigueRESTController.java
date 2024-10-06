package com.youssef.equipes.RESTControllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.youssef.equipes.entities.Ligue;
import com.youssef.equipes.repo.LigueRepository;

@RestController
@RequestMapping("/api/ligue")
@CrossOrigin("*")
public class LigueRESTController {

    @Autowired
    LigueRepository ligueRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Ligue> getAllLigues() {
        return ligueRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Ligue getLigueById(@PathVariable("id") Long id) {
        
        return ligueRepository.findById(id).get();
                    
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createLigue(@RequestBody Ligue ligue) {
        ligueRepository.save(ligue);
        
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteLigue(@PathVariable("id") Long id) {
      
            ligueRepository.deleteById(id);
      
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateLigue(@RequestBody Ligue ligue) {
             ligueRepository.save(ligue);
      
    }
}
