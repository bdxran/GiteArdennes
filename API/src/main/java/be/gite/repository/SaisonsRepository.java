package be.gite.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import be.gite.entity.Saisons;

public interface SaisonsRepository extends JpaRepository<Saisons, Integer>, JpaSpecificationExecutor<Saisons>{

	@Query("SELECT s FROM Saisons s WHERE s.nom = :nom")
	Saisons getSaisonByName(@Param("nom") String nom);
	
	@Query("SELECT s FROM Saisons s WHERE s.dateDebut<:dateDebut AND s.dateFin>:date")
	Saisons getSaisonByDateDebut(@Param("date") Date date);
	
	@Query("SELECT s FROM Saisons s WHERE s.dateDebut<:dateFin AND s.dateFin>:date")
	Saisons getSaisonByDateFin(@Param("date") Date date);
}
