package be.gite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import be.gite.entity.Publiques;
import be.gite.service.PubliquesService;

@RestController
@RequestMapping(path = "/publiques")
public class PubliquesController {

	@Autowired
	private PubliquesService service;

	@GetMapping
	@ResponseStatus(HttpStatus.FOUND)
	@ResponseBody
	public Iterable<Publiques> getPubliques() {
		return service.getPubliques();
	}

	@GetMapping(value = "{id}")
	@ResponseStatus(HttpStatus.FOUND)
	@ResponseBody
	public Publiques getPubliquesById(@PathVariable Integer id) {
		return service.getPubliquesById(id);
	}

	@GetMapping(value = "/name/{nom}/{prenom}")
	@ResponseStatus(HttpStatus.FOUND)
	@ResponseBody
	public List<Publiques> getPubliquesByName(@PathVariable String nom, @PathVariable String prenom) {
		return service.getPubliquesByName(nom, prenom);
	}

	@GetMapping(value = "/id/{email}/{racine}")
	@ResponseStatus(HttpStatus.FOUND)
	@ResponseBody
	public Integer getIdPublique(@PathVariable String email, @PathVariable String racine) {
		email = email.concat("."+racine);
		System.out.println(email);
		return service.getIdPublique(email);
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Publiques newPublique(@RequestBody Publiques publique) {
		return service.newPublique(publique);
	}
	
	@PutMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Publiques updatePublique(@RequestBody Publiques publique) {
		return service.newPublique(publique);
	}
}
