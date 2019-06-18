package be.gite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import be.gite.entity.Gites;
import be.gite.service.GitesService;

@RestController
@RequestMapping(path = "/gites")
public class GitesController {

	@Autowired
	private GitesService service;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Iterable<Gites> getGites() {
		return service.findAll();
	}
	
	@GetMapping(value = "/id/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Gites getGitesById(@PathVariable Integer id) {
		return service.getGitesById(id);
	}
	
	@GetMapping(value = "/nom/{nom}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Integer getIdGites(@PathVariable String nom) {
		return service.getIdGites(nom);
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Gites newGite(@RequestBody Gites gite) {
		return service.create(gite);
	}
	
	@PutMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.ACCEPTED)
	@ResponseBody
	public Gites updateGite(@RequestBody Gites gite) {
		return service.create(gite);
	}
	
	@DeleteMapping(value = "{id}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void deleteGite(@PathVariable Integer id) {
		service.deleteGite(id);
	}
}
