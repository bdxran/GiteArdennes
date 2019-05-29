package be.gite.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import be.gite.entity.Photos;
import be.gite.service.PhotosService;

@RestController
@RequestMapping(path="/photos")
public class PhotosController {

private static final Logger logger = LoggerFactory.getLogger(Photos.class);
	
	@Autowired
	private PhotosService photosService;
	
	@GetMapping
	public @ResponseBody Iterable<Photos> getAllPhotos() {
		return photosService.findAll();
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Photos> newGite (@RequestBody Photos photo) {
		if(photo == null) {
			logger.info("Gite is null, itsn't recording",photo);
			return new ResponseEntity<Photos>(HttpStatus.NOT_FOUND);
		} else if(photosService.exist(photo)) {
			logger.info("Gite is exist, itsn't recording",photo);
			return new ResponseEntity<Photos>(HttpStatus.CONFLICT);
		} else {
			System.out.println(photo);
			photosService.create(photo);
			logger.info("Gite is recording",photo);
			return new ResponseEntity<Photos>(photo,HttpStatus.CREATED);
		}	
	}
}
