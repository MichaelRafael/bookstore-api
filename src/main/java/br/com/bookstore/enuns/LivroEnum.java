package br.com.bookstore.enuns;

import br.com.bookstore.exceptions.IllegalArgumentException;

public enum LivroEnum {

    PEQUENO(0),
    MEDIO(1),
    GRANDE(2);

    private Integer codigo;

    LivroEnum(Integer codigo) {
        this.codigo = codigo;
    }
}
