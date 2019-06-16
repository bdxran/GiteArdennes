package be.gite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.gite.entity.Saisons;
import be.gite.repository.SaisonsRepository;

@Service
public class SaisonsServiceImpl implements SaisonsService {

	@Autowired
	private SaisonsRepository repository;

	public Iterable<Saisons> getSaisons() {
		return repository.findAll();
	}

	public Saisons getSaisonById(Integer id) {
		return repository.findById(id).get();
	}

	public Saisons getSaisonByName(String nom) {
		return repository.getSaisonByName(nom);
	}

	public Saisons newSaison(Saisons saison) {
		return repository.save(saison);
	}
}
