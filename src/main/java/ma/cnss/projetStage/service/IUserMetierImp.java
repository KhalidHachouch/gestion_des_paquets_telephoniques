package ma.cnss.projetStage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ma.cnss.projetStage.entities.User;
import ma.cnss.projetStage.repository.userRepository;

@Service
public class IUserMetierImp implements IUserMetier {
	@Autowired
	private userRepository usrRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return usrRepository.save(user);
	}
	@Override
	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		
		return usrRepository.existsByEmail(email);
	}

}
