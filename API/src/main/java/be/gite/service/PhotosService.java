package be.gite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.gite.entity.Photos;
import be.gite.repository.PhotosRepository;

@Service
public class PhotosService {

	@Autowired
	private PhotosRepository photosRepository;
	
	public Photos create(Photos photo) {
		return photosRepository.save(photo);
	}
	
	public Boolean exist(Photos photo) {
		return photosRepository.existsById(photo.getIdPhoto());
	}
	
	public List<Photos> findAll(){
		return photosRepository.findAll();
	}
}
