package be.gite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import be.gite.entity.Admins;
import be.gite.entity.Gites;
import be.gite.entity.Publiques;
import be.gite.entity.Reservations;
import be.gite.service.ReservationsService;

@RestController
@RequestMapping(path = "/reservations")
public class ReservationsController {

	@Autowired
	private ReservationsService service;

	@GetMapping
	@ResponseStatus(HttpStatus.FOUND)
	@ResponseBody
	public Iterable<Reservations> getReservations() {
		return service.getReservations();
	}

	@GetMapping(value = "/id/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	@ResponseBody
	public Reservations getReservationById(@PathVariable Integer id) {
		return service.getReservationById(id);
	}

	@PostMapping(consumes = "applications/json", value = "/gite")
	@ResponseStatus(HttpStatus.FOUND)
	@ResponseBody
	public List<Reservations> getReservationByIdGite(@RequestBody Gites idGite) {
		return service.getReservationsByIdGite(idGite);
	}

	@PostMapping(consumes = "applications/json", value = "/publiques")
	@ResponseStatus(HttpStatus.FOUND)
	@ResponseBody
	public List<Reservations> getReservationByIdPublique(@RequestBody Publiques idPublique) {
		return service.getReservationsByIdPublique(idPublique);
	}

	@PostMapping(consumes = "applications/json", value = "/admin")
	@ResponseStatus(HttpStatus.FOUND)
	@ResponseBody
	public List<Reservations> getReservationByIdAdmin(@RequestBody Admins idAdmin) {
		return service.getReservationsByIdAdmin(idAdmin);
	}

	@PostMapping(consumes = "applications/json")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Reservations newReservation(@RequestBody Reservations reservation) {
		return service.newReservation(reservation);
	}
}
