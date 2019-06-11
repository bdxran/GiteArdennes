package be.gite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.gite.entity.Admins;
import be.gite.repository.AdminsRepository;

@Service(value = "AdminsService")
public class AdminsServiceImpl implements AdminsService{
	@Autowired
	private AdminsRepository repository;

	public List<Admins> findAll() {
		return repository.findAll();
	}

	public Integer getIdAdmin(String username) {
		return repository.getIdAdmin(username);
	}

	public Admins getAdminsById(Integer id) {
		return repository.findById(id).get();
	}

	public Admins create(Admins admin) {
		return repository.save(admin);
	}

	public Boolean exist(Admins admin) {
		return repository.existsById(admin.getIdAdmin());
	}
}
