package be.gite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.gite.entity.Villes;
import be.gite.repository.VillesRepository;

@Service
public class VillesServiceImpl implements VillesService {

	@Autowired
	private VillesRepository repository;

	public Iterable<Villes> getVilles() {
		return repository.findAll();
	}

	public Villes getVilleById(Integer id) {
		return repository.findById(id).get();
	}

	public Villes getVilleByName(String nom) {
		return repository.getVilleByName(nom);
	}
	
	public Villes newVille(Villes ville) {
		return repository.save(ville);
	}
}
