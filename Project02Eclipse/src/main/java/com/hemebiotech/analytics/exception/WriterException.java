package com.hemebiotech.analytics.exception;

public class WriterException extends RuntimeException {

    /**
     * Exception called when there is an error while writing something...
     * @param message to be displayer
     * @param cause to be throwed.
     */
    public WriterException(String message, Throwable cause) {
        super(message, cause);
    }

}
