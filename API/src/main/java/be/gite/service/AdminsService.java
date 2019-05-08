package be.gite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.gite.entity.Admins;
import be.gite.repository.AdminsRepository;

@Service
public class AdminsService {

	@Autowired
	private AdminsRepository adminsRepository;
	
	public Admins create(Admins admin) {
		return adminsRepository.save(admin);
	}
	
	public Boolean exist(Admins admin) {
		return adminsRepository.existsById(admin.getIdAdmin());
	}
	
	public List<Admins> findAll(){
		return adminsRepository.findAll();
	}
}
