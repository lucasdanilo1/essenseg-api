package sistema.essenseg.dto.exceptionHandler;

import org.springframework.validation.FieldError;

public record DadosErroValidacaoDTO(String field, String message) {

    public DadosErroValidacaoDTO(FieldError error){
        this(error.getField(), error.getDefaultMessage());
    }

}
