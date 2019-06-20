package be.gite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.gite.entity.Publiques;
import be.gite.repository.PubliquesRepository;

@Service
public class PubliquesServiceImpl implements PubliquesService {

	@Autowired
	private PubliquesRepository repository;

	public Iterable<Publiques> getPubliques() {
		return repository.findAll();
	}

	public Publiques getPubliquesById(Integer id) {
		return repository.findById(id).get();
	}

	public List<Publiques> getPubliquesByName(String nom, String prenom) {
		return repository.getPubliquesByName(nom, prenom);
	}

	public Publiques getIdPublique(String email) {
		return repository.getIdPublique(email);
	}

	public Publiques newPublique(Publiques publique) {
		return repository.save(publique);
	}
}
