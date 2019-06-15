package be.gite.service;

import be.gite.entity.Pays;

public interface PaysService {

	Iterable<Pays> getPays();

	Pays getPaysById(Integer id);

	Pays getPaysByName(String nom);

	Pays newPays(Pays pays);
}
