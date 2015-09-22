package ar.com.ludat.PypinApi;

import org.mule.module.apikit.exception.MuleRestException;

public class Package {
	private String name;
	private String version;
	
	public Package(String name) throws MuleRestException {
		this.name = name;
		// There should be something checking if the name is valid
		// but for now its okay
		this.version = "1.0.0";
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getVersion(){
		return this.version;
	}
}
