package be.gite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.gite.entity.Pays;
import be.gite.repository.PaysRepository;

@Service
public class PaysServiceImpl implements PaysService {

	@Autowired
	private PaysRepository repository;

	public Iterable<Pays> getPays() {
		return repository.findAll();
	}

	public Pays getPaysById(Integer id) {
		return repository.findById(id).get();
	}

	public Pays getPaysByName(String nom) {
		return repository.getPaysByName(nom);
	}

	public Pays newPays(Pays pays) {
		return repository.save(pays);
	}
}
