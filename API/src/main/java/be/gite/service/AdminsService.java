package be.gite.service;

import java.util.List;

import be.gite.entity.Admins;

public interface AdminsService {

	List<Admins> findAll();

	Integer getIdAdmin(String username);

	Admins getAdminsById(Integer id);

	Admins create(Admins admin);

	Boolean exist(Admins admin);

}
