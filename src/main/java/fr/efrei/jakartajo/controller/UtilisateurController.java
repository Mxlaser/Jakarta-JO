package fr.efrei.jakartajo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.efrei.jakartajo.model.Utilisateur;
import fr.efrei.jakartajo.service.UtilisateurService;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    private final UtilisateurService service;

    public UtilisateurController(UtilisateurService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Utilisateur>> findAll(){
        return new ResponseEntity<>(service.findAllUtilisateurs(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> findOneById(@PathVariable String id){
        Utilisateur utilisateur = service.findUtilisateurById(id);
        if(utilisateur != null){
            return new ResponseEntity<>(service.findUtilisateurById(id), HttpStatus.OK);
        }
        
    }
    @PostMapping
    public ResponseEntity<Utilisateur> save(@Valid @RequestBody CreateUtilisateur utilisateur){
       Utilisateur createUtilisateur = service.create(utilisateur);
       return new ResponseEntity<>(createUtilisateur, HttpStatus.CREATED); 
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        boolean isDeleted = service.delete(id);
        if(isDeleted){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> miseAJourTotal(
        @PathVariable String id,
        @RequestBody UpdateUtilisateur utilisateur){
            boolean isUpdated = service.update(id, utilisateur);
            if(isUpdated){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    @PatchMapping("{id}")  
    public ResponseEntity<?> miseAJourPartielle(
            @PathVariable String id,
            @RequestBody UpdateUtilisateur utilisateur){
        boolean isUpdated = service.updatePartielle(id, utilisateur);
        if(isUpdated){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
    

}
