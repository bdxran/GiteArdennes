package be.gite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import be.gite.entity.Admins;

public interface AdminsRepository extends JpaRepository<Admins, Integer> {}
