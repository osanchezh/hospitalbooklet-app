package org.hospitalbooklet.soa.commons.exception;

public class HospitalBookletServicesException  extends Exception {

	private static final long serialVersionUID = -278729312055876370L;

 
	public HospitalBookletServicesException() {
         super();

    }


    public HospitalBookletServicesException(String message) {
        super(message);

    }


    public HospitalBookletServicesException(String message, Throwable cause) {
        super(message, cause);

    }


    public HospitalBookletServicesException(Throwable cause) {
        super(cause);

    }
}