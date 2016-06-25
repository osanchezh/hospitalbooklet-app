package org.hospitalbooklet.soa.commons.exception;

public class HospitalBookletFrontException  extends Exception {

	private static final long serialVersionUID = -278729312055876370L;

 
	public HospitalBookletFrontException() {
         super();

    }


    public HospitalBookletFrontException(String message) {
        super(message);

    }


    public HospitalBookletFrontException(String message, Throwable cause) {
        super(message, cause);

    }


    public HospitalBookletFrontException(Throwable cause) {
        super(cause);

    }
}