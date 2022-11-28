package ma.cnss.projetStage.service;

import ma.cnss.projetStage.entities.User;

public interface IUserMetier{
	public User createUser(User user);
	public boolean checkEmail(String email);
}
