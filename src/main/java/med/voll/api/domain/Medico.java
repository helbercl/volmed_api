package med.voll.api.domain;

import jakarta.persistence.*;
import lombok.*;

import med.voll.api.dto.medico.MedicoDTO;
import med.voll.api.dto.medico.MedicoPutDTO;
import med.voll.api.enumeracao.EspecialidadeEnum;


@Entity
@Table(name ="tb_medico")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_medicos")
    @SequenceGenerator(name = "sq_medicos", sequenceName = "sq_medicos", allocationSize = 1)

    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String crm;
    private Boolean status;

    @Enumerated(EnumType.STRING)
    private EspecialidadeEnum especialidade;

    @Embedded
    private Endereco endereco;

    public Medico(MedicoDTO medicoDTO) {
        this.nome = medicoDTO.nome();
        this.crm = medicoDTO.crm();
        this.email = medicoDTO.email().toLowerCase();
        this.telefone = medicoDTO.telefone();
        this.especialidade = medicoDTO.especialidade();
        this.endereco = new Endereco(medicoDTO.endereco());
        this.status = true;
    }

    public void atualizar(MedicoPutDTO medicoPutDTO){
        if (medicoPutDTO.nome()!=null)
            this.nome = medicoPutDTO.nome();
        if (medicoPutDTO.telefone()!=null)
            this.telefone = medicoPutDTO.telefone();
        if (medicoPutDTO.endereco()!=null)
            this.endereco.atualizar(medicoPutDTO.endereco());
        if (medicoPutDTO.status()!=null)
            this.status = medicoPutDTO.status();

    }

    public void deletar() {
        this.status=false;
    }
}
