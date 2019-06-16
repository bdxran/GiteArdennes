package be.gite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.gite.entity.Admins;
import be.gite.entity.Gites;
import be.gite.entity.Publiques;
import be.gite.entity.Reservations;
import be.gite.repository.ReservationsRepository;

@Service
public class ReservationsServiceImpl implements ReservationsService {

	@Autowired
	private ReservationsRepository repository;

	public Iterable<Reservations> getReservations() {
		return repository.findAll();
	}

	public Reservations getReservationById(Integer id) {
		return repository.findById(id).get();
	}

	public List<Reservations> getReservationsByIdGite(Gites idGite) {
		return repository.getReservationsByIdGite(idGite);
	}

	public List<Reservations> getReservationsByIdPublique(Publiques idPublique) {
		return repository.getReservationsByIdPublique(idPublique);
	}

	public List<Reservations> getReservationsByIdAdmin(Admins idAdmin) {
		return repository.getReservationsByIdAdmin(idAdmin);
	}

	public Reservations newReservation(Reservations reservation) {
		return repository.save(reservation);
	}
	
	public void deleteReservation(Integer id) {
		repository.deleteById(id);;
	}
}
