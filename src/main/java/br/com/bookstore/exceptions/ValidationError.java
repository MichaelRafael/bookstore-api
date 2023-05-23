package br.com.bookstore.exceptions;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError implements Serializable {
     private static final long serialVersionUID = 1L;

     private List<FieldMessage> erros = new ArrayList<>();

    public ValidationError() {
        super();
    }

    public ValidationError(LocalDateTime timesTemp, Integer status, String error, String path) {
        super(timesTemp, status, error, path);
    }

    public List<FieldMessage> getErros() {
        return erros;
    }

    public void addErros(String fieldName, String message) {
        this.erros.add(new FieldMessage(fieldName, message));
    }
}
