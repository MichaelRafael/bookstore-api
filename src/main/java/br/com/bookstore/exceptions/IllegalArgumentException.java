package br.com.bookstore.exceptions;

public class IllegalArgumentException extends RuntimeException{

    public IllegalArgumentException(String message) {
        super(message);
    }
}
