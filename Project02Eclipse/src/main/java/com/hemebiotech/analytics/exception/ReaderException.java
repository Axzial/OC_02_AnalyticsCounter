package com.hemebiotech.analytics.exception;

public class ReaderException extends RuntimeException {

    /**
     * Exception called when there is an error while reading something...
     * @param message to be displayer
     * @param cause to be throwed.
     */
    public ReaderException(String message, Throwable cause) {
        super(message, cause);
    }

}
