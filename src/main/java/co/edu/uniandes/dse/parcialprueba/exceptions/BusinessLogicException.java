package co.edu.uniandes.dse.parcialprueba.exceptions;

/**
 * Excepción de lógica de negocio.
 */
public class BusinessLogicException extends Exception {

    private static final long serialVersionUID = 1L;

    public BusinessLogicException() {
        super();
    }

    public BusinessLogicException(String message) {
        super(message);
    }

    public BusinessLogicException(String message, Throwable cause) {
        super(message, cause);
    }
}
