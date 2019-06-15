package be.gite.service;

import be.gite.entity.Villes;

public interface VillesService {

	Iterable<Villes> getVilles();

	Villes getVilleById(Integer id);

	Villes getVilleByName(String nom);

	Villes newVille(Villes ville);
}
