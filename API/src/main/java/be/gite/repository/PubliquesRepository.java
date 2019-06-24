package be.gite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import be.gite.entity.Publiques;

public interface PubliquesRepository extends JpaRepository<Publiques, Integer>, JpaSpecificationExecutor<Publiques> {
	@Query("SELECT p from Publiques p where p.nom = :nom AND p.prenom = :prenom")
	List<Publiques> getPubliquesByName(@Param("nom") String nom, @Param("prenom") String prenom);

	@Query("SELECT p from Publiques p where p.email = :email")
	Publiques getIdPublique(@Param("email") String email);
}
