package med.voll.api.domain;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.dto.paciente.PacienteDTO;
import med.voll.api.dto.paciente.PacientePutDTO;

@Entity
@Table(name = "tb_paciente")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode(of = "id")
public class Paciente {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_paciente")
    @SequenceGenerator(name ="sq_paciente",sequenceName = "sq_paciente",initialValue = 1,allocationSize = 1)
    private Long id;

    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private Boolean status;

    @Embedded
    private Endereco endereco;


    public Paciente(PacienteDTO pacienteDTO) {
        this.nome = pacienteDTO.nome();
        this.email = pacienteDTO.email().toLowerCase();
        this.cpf = pacienteDTO.cpf();
        this.telefone = pacienteDTO.telefone();
        this.status = true;
        this.endereco = new Endereco(pacienteDTO.endereco());
    }

    public void atualizar(PacientePutDTO pacientePutDTO) {
        if (pacientePutDTO.nome() != null)
            this.nome = pacientePutDTO.nome();

        if (pacientePutDTO.telefone() != null)
            this.telefone = pacientePutDTO.telefone();

        if (pacientePutDTO.endereco() != null)
            this.endereco.atualizar(pacientePutDTO.endereco());
        if (pacientePutDTO.status()!=null)
            this.status = pacientePutDTO.status();
    }
    public void inativar() {
        this.status = false;
    }
}
