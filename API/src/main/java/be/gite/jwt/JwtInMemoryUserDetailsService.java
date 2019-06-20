package be.gite.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import be.gite.entity.Admins;
import be.gite.entity.Publiques;
import be.gite.repository.AdminsRepository;
import be.gite.repository.PubliquesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

  @Autowired
  AdminsRepository adminsRepository;
  
  @Autowired
  PubliquesRepository publiquesRepository;
	
	
  static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

  //static {
  //  inMemoryUserList.add(new JwtUserDetails(1L, "toto",
  //      "$2a$10$Bi7DWJTLZp4fjT8oT96q0erNCzQD5QtR62uT1v7QFWddmp3c9.g.G", "ADMIN"));
  //}

  @Override
  public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
    
	  Optional<Admins> stu = adminsRepository.adminByLogin(login).stream().findFirst();
	  
	  Publiques pub = publiquesRepository.getIdPublique(login);
	    
	  Optional<JwtUserDetails> user = Optional.empty();
	  
	  if(stu.isPresent()) {
		  user = Optional.of(new JwtUserDetails(new Long(stu.get().getIdAdmin()),stu.get().getLogin(),stu.get().getMdp(),"USER_ADMIN")); 
	  } else if(pub != null) {
		  user = Optional.of(new JwtUserDetails(new Long(pub.getIdPublique()),pub.getEmail(),pub.getMdp(),"USER_CLIENT")); 
	  }
	  
	  //Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
      //  .filter(user -> user.getUsername().equals(username)).findFirst();

    if (!user.isPresent()) {
      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", login));
    }

    return user.get();
  }

}


