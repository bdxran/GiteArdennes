package be.gite.repository;

import be.gite.entity.Gite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiteRepository extends JpaRepository<Gite, Integer> {}
