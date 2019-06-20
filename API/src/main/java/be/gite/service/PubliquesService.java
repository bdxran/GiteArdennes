package be.gite.service;

import java.util.List;

import be.gite.entity.Publiques;

public interface PubliquesService {

	Iterable<Publiques> getPubliques();

	Publiques getPubliquesById(Integer id);

	List<Publiques> getPubliquesByName(String nom, String prenom);

	Publiques getIdPublique(String email);

	Publiques newPublique(Publiques publique);

}
