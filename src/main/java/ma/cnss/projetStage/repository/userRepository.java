package ma.cnss.projetStage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.cnss.projetStage.entities.User;
@Repository
public interface userRepository extends JpaRepository<User, Long> {

	public Boolean existsByEmail(String email);
	
	public User findByUsername(String username);
}
