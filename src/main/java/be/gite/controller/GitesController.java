package be.gite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import be.gite.entity.Gites;
import be.gite.repository.GitesRepository;

@Controller
@RequestMapping(path="/gites")
public class GitesController {
	
	@Autowired
	private GitesRepository gitesRepository;
	
	@GetMapping(path="/add")
	public @ResponseBody String addNewGite (@RequestParam String idAdmin,@RequestParam String nom, @RequestParam String adresse1, @RequestParam String adresse2, @RequestParam String description) {
		try {
			Gites gites = new Gites();
			gites.setNom(idAdmin);
			gites.setNom(nom);
			gites.setAdresse1(adresse1);
			gites.setAdresse2(adresse2);
			gites.setDescription(description);
			gitesRepository.save(gites);
		} catch(Exception e) {
			return "It'snt recording!";
		}
		return "It's recording!";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Gites> getAllGite() {
		return gitesRepository.findAll();
	}
}
