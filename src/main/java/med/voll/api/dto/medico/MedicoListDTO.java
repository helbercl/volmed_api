package med.voll.api.dto.medico;

import med.voll.api.domain.Medico;
import med.voll.api.enumeracao.EspecialidadeEnum;

public record MedicoListDTO(
        Long id,
        String nome,
        String email,
        String crm,
        EspecialidadeEnum especialidadeEnum,
        Boolean status
) {
    public MedicoListDTO(Medico medico){
        this(medico.getId(),medico.getNome(),medico.getEmail(), medico.getCrm(), medico.getEspecialidade(),medico.getStatus());
    }
}
