package be.gite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import be.gite.entity.Gite;
import be.gite.repository.GiteRepository;

@Controller
@RequestMapping(path="/gite")
public class GiteController {
	
	@Autowired
	private GiteRepository giteRepository;
	
	@GetMapping(path="/add")
	public @ResponseBody String addNewGite (@RequestParam String nom, @RequestParam String adresse1, @RequestParam String adresse2, @RequestParam String description) {
		System.out.println(nom+adresse1+adresse2+description);
		try {
			Gite gite = new Gite(nom,adresse1,adresse2,description);
			giteRepository.save(gite);
		} catch(Exception e) {
			return "It'snt recording!";
		}
		return "It's recording!";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Gite> getAllGite() {
		return giteRepository.findAll();
	}
}
