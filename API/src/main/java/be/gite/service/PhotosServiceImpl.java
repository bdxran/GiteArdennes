package be.gite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.gite.entity.Gites;
import be.gite.entity.Photos;
import be.gite.repository.PhotosRepository;

@Service(value = "PhotosService") // l'annotation @Service est optionnelle ici, car il n'existe qu'une seule
									// implémentation de l'interface PhotosService
public class PhotosServiceImpl implements PhotosService {
	@Autowired
	private PhotosRepository repository;
	
	public List<Photos> findAll() {
		return repository.findAll();
	}

	public Photos getPhotosById(Integer id) {
		return repository.findById(id).get();
	}

	public List<Photos> getPhotosByIdGite(Gites idGite) {
		return repository.getByIdGite(idGite);
	}

	public Photos create(Photos photo) {
		return repository.save(photo);
	}

	public Boolean exist(Photos photo) {
		return repository.existsById(photo.getIdPhoto());
	}
}
