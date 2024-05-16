package fr.efrei.jakartajo.controller;

import fr.efrei.jakartajo.model.Acheteur;
import fr.efrei.jakartajo.service.AcheteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/acheteurs")
public class AcheteurController {

	private final AcheteurService service;

	@Autowired
	public AcheteurController(AcheteurService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Acheteur>> findAll() {
		return new ResponseEntity<>(service.findAllAcheteurs(), HttpStatus.OK);
	}

	@GetMapping("/{uuid}")
	public ResponseEntity<Acheteur> findOneById(@PathVariable String uuid) {
		Acheteur student = service.findAcheteurById(uuid);
		if (student != null) {
			return new ResponseEntity<>(service.findAcheteurById(uuid), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Acheteur> save(@RequestBody Acheteur acheteur) {
		Acheteur createdStudent = service.create(acheteur);
		return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
	}

	@DeleteMapping("/{uuid}")
	public ResponseEntity<?> delete(@PathVariable String uuid) {
		boolean isDeleted = service.delete(uuid);
		if(isDeleted) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
