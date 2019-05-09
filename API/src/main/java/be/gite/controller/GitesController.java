package be.gite.controller;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import be.gite.entity.Gites;
import be.gite.service.GitesService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/gites")
public class GitesController {
	
	private static final Logger logger = LoggerFactory.getLogger(Gites.class);
	
	@Autowired
	private GitesService gitesService;
	
	@GetMapping
	public @ResponseBody Iterable<Gites> getAllGites() {
		return gitesService.findAll();
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Gites> newGite (@RequestBody Gites gite) {
		if(gite == null) {
			logger.info("Gite is null, itsn't recording",gite);
			return new ResponseEntity<Gites>(HttpStatus.NOT_FOUND);
		} else if(gitesService.exist(gite)) {
			logger.info("Gite is exist, itsn't recording",gite);
			return new ResponseEntity<Gites>(HttpStatus.CONFLICT);
		} else {
			gitesService.create(gite);
			logger.info("Gite is recording",gite);
			return new ResponseEntity<Gites>(gite,HttpStatus.CREATED);
		}	
	}
}
