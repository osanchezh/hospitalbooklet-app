package org.hospitalbooklet.soa.commons.exception;

public class HospitalBookletDatabaseException  extends Exception {

    private static final long serialVersionUID  = 4356630206011251573L;


    public HospitalBookletDatabaseException() {
        super();

    }


    public HospitalBookletDatabaseException(String message) {
        super(message);

    }


    public HospitalBookletDatabaseException(String message, Throwable cause) {
        super(message, cause);

    }


    public HospitalBookletDatabaseException(Throwable cause) {
        super(cause);

    }
}
