package ar.com.ludat.PypinApi;

import org.mule.config.i18n.Message;
import org.mule.module.apikit.exception.MuleRestException;

public class UnauthorizedException extends MuleRestException {

	public UnauthorizedException() {
		// TODO Auto-generated constructor stub
	}

	public UnauthorizedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UnauthorizedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public UnauthorizedException(Message message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
