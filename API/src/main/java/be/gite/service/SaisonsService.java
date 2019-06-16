package be.gite.service;

import be.gite.entity.Saisons;

public interface SaisonsService {

	Iterable<Saisons> getSaisons();

	Saisons getSaisonById(Integer id);

	Saisons getSaisonByName(String nom);

	Saisons newSaison(Saisons saison);
}
