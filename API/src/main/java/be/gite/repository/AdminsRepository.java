package be.gite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import be.gite.entity.Admins;

public interface AdminsRepository extends JpaRepository<Admins, Integer>, JpaSpecificationExecutor<Admins> {
	@Query("SELECT l from Admins l where l.login = :login")
	List<Admins> adminByLogin(@Param("login") String login);
}
