package be.gite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import be.gite.entity.Admins;
import be.gite.service.AdminsService;

@RestController
@RequestMapping(path = "/admins")
public class AdminsController {

	@Autowired
	private AdminsService service;

	@GetMapping
	@ResponseStatus(HttpStatus.FOUND)
	@ResponseBody
	public Iterable<Admins> getAdmins() {
		return service.findAll();
	}

	@GetMapping(value = "/login/{username}")
	@ResponseStatus(HttpStatus.FOUND)
	@ResponseBody
	public Integer getIdAdmin(@PathVariable String username) {
		System.out.println(username);
		return service.getIdAdmin(username);
	}

	@GetMapping(value = "{id}")
	@ResponseStatus(HttpStatus.FOUND)
	@ResponseBody
	public Admins getAdminById(@PathVariable Integer id) {
		return service.getAdminsById(id);
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Admins newAdmin(@RequestBody Admins admin) {
		return service.create(admin);
	}
}
