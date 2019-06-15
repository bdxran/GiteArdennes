package be.gite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import be.gite.entity.Villes;

public interface VillesRepository extends JpaRepository<Villes, Integer>, JpaSpecificationExecutor<Villes> {
	@Query("SELECT p from Villes p where p.nom = :nom")
	Villes getVilleByName(@Param("nom") String nom);
}
