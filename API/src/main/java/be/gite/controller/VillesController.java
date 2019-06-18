package be.gite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import be.gite.entity.Villes;
import be.gite.service.VillesService;

@RestController
@RequestMapping(path = "/villes")
public class VillesController {

	@Autowired
	private VillesService service;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Iterable<Villes> getVilles() {
		return service.getVilles();
	}

	@GetMapping(value = "/id/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Villes getVilleById(@PathVariable Integer id) {
		return service.getVilleById(id);
	}

	@GetMapping(value = "{nom}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Villes getVilleByName(@PathVariable String nom) {
		return service.getVilleByName(nom);
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Villes newVille(@RequestBody Villes ville) {
		return service.newVille(ville);
	}
	
	@PutMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.ACCEPTED)
	@ResponseBody
	public Villes updateVille(@RequestBody Villes ville) {
		return service.newVille(ville);
	}
}
