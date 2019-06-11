package be.gite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import be.gite.entity.Photos;
import be.gite.service.PhotosService;

@RestController
@RequestMapping(path = "/photos")
public class PhotosController {

	@Autowired
	private PhotosService service;

	@GetMapping
	@ResponseStatus(HttpStatus.FOUND)
	@ResponseBody
	public Iterable<Photos> getPhotos() {
		return service.findAll();
	}

	@GetMapping(value = "{id}")
	@ResponseStatus(HttpStatus.FOUND)
	@ResponseBody
	public Photos getPhotosById(@PathVariable Integer id) {
		return service.getPhotosById(id);
	}

	@GetMapping(value = "/idGite/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	@ResponseBody
	public List<Photos> getPhotosByIdGite(@PathVariable Integer id) {
		return service.getPhotosByIdGite(id);
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Photos newGite(@RequestBody Photos photo) {
		return service.create(photo);
	}
}
