package ar.com.ludat.PypinApi;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashSet;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;
import org.mule.module.apikit.exception.InvalidQueryParameterException;
import org.mule.module.apikit.exception.MuleRestException;

@JsonAutoDetect
public class User {
	private InternetAddress mail;
	private String password;
	private Boolean is_activated = false;
	private HashSet<String> packages = new HashSet<String>();
	
	public User(String mail) throws MuleRestException {
		try {
			this.mail = new InternetAddress(mail);
		} catch (AddressException e) {
			throw new InvalidQueryParameterException("Mail is not valid");
		}
		SecureRandom random = new SecureRandom();
		this.password = new BigInteger(130, random).toString(32);
		this.sendMail("Hi " + this.mail + " Your password is: " + this.password);
	}
	
	public void sendMail(String content){
		// Stub for sending mails
		// I may need an external SMTP server to send the mails D:
		System.out.println("To: " + this.mail);
		System.out.println(content);
	}
	
	@JsonProperty
	public String getMail(){
		return this.mail.toString();
	}
	
	@JsonProperty
	public HashSet<String> getPackages(){
		return this.packages;
	}
	
	public Boolean authenticate(String password){
		return this.password.equals(password);
	}

	public void addPackage(String name){
		this.packages.add(name.toLowerCase());
	}
	
	public void deletePackage(String name){
		this.packages.remove(name.toLowerCase());
	}

	public void activate(){
		this.is_activated = true;
	}

	public Boolean isActivated(){
		return this.is_activated;
	}
}