package med.voll.api.dto.paciente;

import med.voll.api.domain.Paciente;

public record PacienteListDTO(String nome, String email, String cpf, String telefone, Boolean status ) {
    public PacienteListDTO(Paciente paciente){
        this(paciente.getNome(),paciente.getEmail(),paciente.getCpf(),paciente.getTelefone(), paciente.getStatus());
    }
}
