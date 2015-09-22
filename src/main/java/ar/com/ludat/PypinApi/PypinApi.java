package ar.com.ludat.PypinApi;

import java.util.Vector;

import org.mule.module.apikit.exception.InvalidQueryParameterException;
import org.mule.module.apikit.exception.MuleRestException;

public class PypinApi {
	private Vector<User> users;
	
	public PypinApi(){
		users = new Vector<User>();
	}
	
	public User addUser(String mail) throws MuleRestException {
		for (User user : this.users){
			if (user.getMail().equals(mail)){
				throw new InvalidQueryParameterException("Mail already registered");
			}
		}
		User new_user = new User(mail);
		this.users.add(new_user);
		return new_user;
	}
	
	public User getUser(String mail, String password) throws MuleRestException {
		for(User user : this.users){
			if (user.getMail().equals(mail) && user.authenticate(password)){
				return user;
			}
		}
		throw new UnauthorizedException("User (" + mail + ") and password (" + password + ") pair are wrong");
	}
	
	public void deleteUser(String mail, String password) throws MuleRestException{
		User user = this.getUser(mail, password);
		this.users.remove(user);
	}
}
