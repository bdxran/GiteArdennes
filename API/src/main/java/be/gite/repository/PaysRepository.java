package be.gite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import be.gite.entity.Pays;

public interface PaysRepository extends JpaRepository<Pays, Integer>, JpaSpecificationExecutor<Pays> {
	@Query("SELECT p from Pays p where p.nom = :nom")
	Pays getPaysByName(@Param("nom") String nom);
}
