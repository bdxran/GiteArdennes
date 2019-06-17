package be.gite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import be.gite.entity.Saisons;
import be.gite.service.SaisonsService;

@RestController
@RequestMapping(path = "/saisons")
public class SaisonsController {

	@Autowired
	private SaisonsService service;

	@GetMapping
	@ResponseStatus(HttpStatus.FOUND)
	@ResponseBody
	public Iterable<Saisons> getSaisons() {
		return service.getSaisons();
	}

	@GetMapping(value = "/id/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	@ResponseBody
	public Saisons getSaisonById(@PathVariable Integer id) {
		return service.getSaisonById(id);
	}

	@GetMapping(value = "/name/{nom}")
	@ResponseStatus(HttpStatus.FOUND)
	@ResponseBody
	public Saisons getSaisonByName(@PathVariable String nom) {
		return service.getSaisonByName(nom);
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Saisons newSaison(@RequestBody Saisons saison) {
		return service.newSaison(saison);
	}
	
	@PutMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.ACCEPTED)
	@ResponseBody
	public Saisons updateSaison(@RequestBody Saisons saison) {
		return service.newSaison(saison);
	}
	
	@DeleteMapping(value = "{id}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void deleteSaison(@PathVariable Integer id) {
		service.deleteSaison(id);
	}
}
