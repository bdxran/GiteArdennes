package be.gite.service;

import java.util.List;

import be.gite.entity.Gites;

public interface GitesService {

	List<Gites> findAll();
	
	Gites getGitesById(Integer id);
	
	Integer getIdGites(String nom);

	Gites create(Gites gite);

	Boolean exist(Gites gite);

}
