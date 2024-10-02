package med.voll.api.dto.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import med.voll.api.dto.EnderecoDTO;


public record MedicoPutDTO(
        @NotNull
        Long id,

        String nome,
        String telefone,
        @Valid EnderecoDTO endereco,
        Boolean status
) {

}
