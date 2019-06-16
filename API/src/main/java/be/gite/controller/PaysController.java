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

import be.gite.entity.Pays;
import be.gite.service.PaysService;

@RestController
@RequestMapping(path = "/pays")
public class PaysController {
	
	@Autowired
	private PaysService service;
	
	@GetMapping
	@ResponseStatus(HttpStatus.FOUND)
	@ResponseBody
	public Iterable<Pays> getPays() {
		return service.getPays();
	}
	
	@GetMapping(value = "/id/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	@ResponseBody
	public Pays getPaysById(@PathVariable Integer id) {
		return service.getPaysById(id);
	}
	
	@GetMapping(value = "{nom}")
	@ResponseStatus(HttpStatus.FOUND)
	@ResponseBody
	public Pays getPaysByName(@PathVariable String nom) {
		return service.getPaysByName(nom);
	}
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Pays newPays(@RequestBody Pays pays) {
		return service.newPays(pays);
	}
	
	@PutMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.ACCEPTED)
	@ResponseBody
	public Pays updatePays(@RequestBody Pays pays) {
		return service.newPays(pays);
	}

}
