package br.com.bookstore.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardError {

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime timesTemp;
    private Integer status;
    private String error;
    private String path;

}
