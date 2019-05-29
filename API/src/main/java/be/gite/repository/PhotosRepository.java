package be.gite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.gite.entity.Photos;

@Repository
public interface PhotosRepository extends JpaRepository<Photos, Integer> {

}
