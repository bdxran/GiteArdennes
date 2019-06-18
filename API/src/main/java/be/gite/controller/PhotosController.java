package be.gite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import be.gite.entity.Gites;
import be.gite.entity.Photos;
import be.gite.service.PhotosService;

@RestController
@RequestMapping(path = "/photos")
public class PhotosController {

	@Autowired
	private PhotosService service;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Iterable<Photos> getPhotos() {
		return service.findAll();
	}

	@GetMapping(value = "{id}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Photos getPhotosById(@PathVariable Integer id) {
		return service.getPhotosById(id);
	}

	@GetMapping(value = "/idGite/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Photos> getPhotosByIdGite(@PathVariable Gites id) {
		return service.getPhotosByIdGite(id);
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Photos newPhoto(@RequestBody Photos photo) {
		return service.create(photo);
	}
	
	@PutMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.ACCEPTED)
	@ResponseBody
	public Photos updatePhoto(@RequestBody Photos photo) {
		return service.create(photo);
	}
	
	@DeleteMapping(value = "{id}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void deletePhoto(@PathVariable Integer id) {
		service.deletePhoto(id);
	}
}
