package br.com.bookstore.exceptions;

public class DataIntegrityViolation extends RuntimeException{

    public DataIntegrityViolation(String message) {
        super(message);
    }
}
