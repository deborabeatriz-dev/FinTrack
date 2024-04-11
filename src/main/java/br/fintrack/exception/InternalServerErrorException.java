package br.fintrack.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * Retorna o erro 500 (INTERNAL SERVER ERROR)
 * 
 */
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerErrorException extends Exception {

    /**
     * Retorna um Exception de Internal Server Error.
     * HTTP CODE: 500
     *
     * @param message the message
     */
    public InternalServerErrorException(String message) {
        super(message);
    }
}
