package be.gite.service;

import java.util.List;

import be.gite.entity.Gites;
import be.gite.entity.Photos;

public interface PhotosService {

	Photos create(Photos photo);

	Boolean exist(Photos photo);

	List<Photos> findAll();

	Photos getPhotosById(Integer id);

	List<Photos> getPhotosByIdGite(Gites idGite);
}
