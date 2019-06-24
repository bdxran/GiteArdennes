package be.gite.service;

import java.util.Date;

import be.gite.entity.Saisons;

public interface SaisonsService {

	Iterable<Saisons> getSaisons();

	Saisons getSaisonById(Integer id);

	Saisons getSaisonByName(String nom);
	
	Saisons getSaisonByDateDebut(Date date);
	
	Saisons getSaisonByDateFin(Date date);

	Saisons newSaison(Saisons saison);
	
	void deleteSaison(Integer id);
}
