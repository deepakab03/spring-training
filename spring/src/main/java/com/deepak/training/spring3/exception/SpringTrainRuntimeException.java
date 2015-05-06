package com.deepak.training.spring3.exception;

/**
 * @author abrahd2
 *
 */
public class SpringTrainRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public SpringTrainRuntimeException() {
    }

    /**
     * @param message
     */
    public SpringTrainRuntimeException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public SpringTrainRuntimeException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public SpringTrainRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }


}
