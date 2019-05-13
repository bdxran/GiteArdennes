package be.gite.controller;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import be.gite.entity.Admins;
import be.gite.service.AdminsService;

@RestController
@RequestMapping(path="/admins")
public class AdminsController {
	
	private static final Logger logger = LoggerFactory.getLogger(Admins.class);
	
	@Autowired
	private AdminsService adminsService;
	
	@GetMapping
	public @ResponseBody Iterable<Admins> getAllAdmins() {
		return adminsService.findAll();
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<Admins> newAdmin (@RequestBody Admins admin) {
		if(admin == null) {
			logger.info("Admin is null, itsn't recording",admin);
			return new ResponseEntity<Admins>(HttpStatus.NOT_FOUND);
		} else if(adminsService.exist(admin)) {
			logger.info("Admin is exist, itsn't recording",admin);
			return new ResponseEntity<Admins>(HttpStatus.CONFLICT);
		} else {
			adminsService.create(admin);
			logger.info("Admin is recording",admin);
			return new ResponseEntity<Admins>(admin,HttpStatus.CREATED);
		}	
	}
}
