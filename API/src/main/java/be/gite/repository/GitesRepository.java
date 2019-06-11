package be.gite.repository;

import be.gite.entity.Gites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GitesRepository extends JpaRepository<Gites, Integer> {
	@Query("SELECT g.idGite from Gites g where g.nom = :nom")
	Integer getIdGites(@Param("nom") String nom);
}
