package be.gite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.gite.entity.Gites;
import be.gite.repository.GitesRepository;

@Service
public class GitesServiceImpl implements GitesService {
	@Autowired
	private GitesRepository repository;
	
	public List<Gites> findAll() {
		return repository.findAll();
	}
	
	public Gites getGitesById(Integer id) {
		return repository.findById(id).get();
	}
	
	public Integer getIdGites(String nom) {
		return repository.getIdGites(nom);
	}

	public Gites create(Gites gite) {
		return repository.save(gite);
	}

	public Boolean exist(Gites gite) {
		return repository.existsById(gite.getIdGite());
	}
}
