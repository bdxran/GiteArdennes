package be.gite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import be.gite.entity.Admins;
import be.gite.repository.AdminsRepository;

@Controller
@RequestMapping(path="/admins")
public class AdminsController {
	@Autowired
	private AdminsRepository adminsRepository;
	
	@GetMapping(path="/add")
	public @ResponseBody String addNewAdmins (@RequestParam String login,@RequestParam String mdp) {
		try {
			Admins admins = new Admins();
			admins.setLogin(login);
			admins.setMdp(mdp);
			adminsRepository.save(admins);
		} catch(Exception e) {
			return "It'snt recording!";
		}
		return "It's recording!";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Admins> getAllAdmins() {
		return adminsRepository.findAll();
	}
}
