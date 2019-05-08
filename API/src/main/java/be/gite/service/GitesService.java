package be.gite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.gite.entity.Gites;
import be.gite.repository.GitesRepository;

@Service
public class GitesService {

	@Autowired
	private GitesRepository gitesRepository;
	
	public Gites create(Gites gite) {
		return gitesRepository.save(gite);
	}
	
	public Boolean exist(Gites gite) {
		return gitesRepository.existsById(gite.getIdGite());
	}
	
	public List<Gites> findAll(){
		return gitesRepository.findAll();
	}
}
