package br.com.iteris.itc.minishop.core.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super(message);
    }
}
