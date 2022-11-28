package ma.cnss.projetStage.sec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ma.cnss.projetStage.entities.User;
import ma.cnss.projetStage.repository.userRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService{
	@Autowired
	private userRepository usrRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=usrRepository.findByUsername(username);
		if(user !=null) {
			return new CustomUserDetails(user);
		}
		throw new UsernameNotFoundException("user not valid");
		
	}

}
