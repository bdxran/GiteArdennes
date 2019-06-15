package be.gite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import be.gite.entity.Gites;
import be.gite.entity.Photos;

@Repository
public interface PhotosRepository extends JpaRepository<Photos, Integer>, JpaSpecificationExecutor<Photos> {
	@Query("SELECT l from Photos l where l.idGite = :idGite")
	List<Photos> getByIdGite(@Param("idGite") Gites idGite);
}
