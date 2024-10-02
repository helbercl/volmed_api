package med.voll.api.dto.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.dto.EnderecoDTO;

public record PacientePutDTO(
        @NotNull
        Long id,
        String nome,
        String telefone,
        @Valid EnderecoDTO endereco,
        Boolean status
){
}
