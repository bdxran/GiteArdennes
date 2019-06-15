package be.gite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import be.gite.entity.Admins;
import be.gite.entity.Gites;
import be.gite.entity.Publiques;
import be.gite.entity.Reservations;

public interface ReservationsRepository extends JpaRepository<Reservations, Integer>, JpaSpecificationExecutor<Reservations> {
	
	@Query("SELECT r from Reservations r where r.idGite = :idGite")
	List<Reservations> getReservationsByIdGite(@Param("idGite") Gites idGites);

	@Query("SELECT r from Reservations r where r.idPublique = :idPublique")
	List<Reservations> getReservationsByIdPublique(@Param("idPublique") Publiques idPublique);

	@Query("SELECT r from Reservations r where r.idAdmin = :idAdmin")
	List<Reservations> getReservationsByIdAdmin(@Param("idAdmin") Admins idAdmin);
	
}
