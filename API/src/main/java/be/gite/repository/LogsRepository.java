package be.gite.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import be.gite.entity.Logs;

public interface LogsRepository extends JpaRepository<Logs, Integer>, JpaSpecificationExecutor<Logs> {
	@Query("Select l FROM Logs l WHERE l.dateLog = :date")
	Iterable<Logs> getLogsByDate(@Param("date") Date date);
}
