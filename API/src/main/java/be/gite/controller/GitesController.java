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
	private GitesService gitesService;

	@GetMapping
	@ResponseStatus(HttpStatus.FOUND)
	@ResponseBody
	public Iterable<Gites> getAllGites() {
		return gitesService.findAll();
	}
	
	@GetMapping(value = "{id}")
	@ResponseStatus(HttpStatus.FOUND)
	@ResponseBody
	public Gites getGitesById(@PathVariable Integer id) {
		return gitesService.getGitesById(id);
	}
	
	@GetMapping(value = "/nom/{nom}")
	@ResponseStatus(HttpStatus.FOUND)
	@ResponseBody
	public Integer getIdGites(@PathVariable String nom) {
		return gitesService.getIdGites(nom);
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Gites newGite(@RequestBody Gites gite) {
		return gitesService.create(gite);
	}
}
