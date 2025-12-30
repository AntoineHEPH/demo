package condorcet.be.demo1.service;

/**
 * Exception personnalisée pour les erreurs métier.
 * Lancée lorsqu'une règle métier est violée.
 */
public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
