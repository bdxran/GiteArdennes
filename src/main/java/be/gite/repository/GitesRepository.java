package be.gite.repository;

import be.gite.entity.Gites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GitesRepository extends JpaRepository<Gites, Integer> {}
