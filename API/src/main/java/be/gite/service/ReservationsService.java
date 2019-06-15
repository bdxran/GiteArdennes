package be.gite.service;

import java.util.List;

import be.gite.entity.Admins;
import be.gite.entity.Gites;
import be.gite.entity.Publiques;
import be.gite.entity.Reservations;

public interface ReservationsService {

	Iterable<Reservations> getReservations();

	Reservations getReservationById(Integer id);

	List<Reservations> getReservationsByIdGite(Gites idGite);

	List<Reservations> getReservationsByIdPublique(Publiques idPublique);

	List<Reservations> getReservationsByIdAdmin(Admins idAdmin);

	Reservations newReservation(Reservations reservation);
}
