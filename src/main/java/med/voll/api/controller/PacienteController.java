package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.Paciente;
import med.voll.api.dto.paciente.PacienteDTO;
import med.voll.api.dto.paciente.PacienteListDTO;
import med.voll.api.dto.paciente.PacientePutDTO;
import med.voll.api.interfaces.persistence.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/pacientes")
public class PacienteController{

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public void inserir(@RequestBody @Valid PacienteDTO pacienteDTO) {
        try {
            pacienteRepository.save(new Paciente(pacienteDTO));
        } catch (Exception e){

        }
    }

    @GetMapping
    public Page<PacienteListDTO> listar(@PageableDefault(page = 0,size = 2, sort = {"nome"}) Pageable pageable){
        return pacienteRepository.findAllByStatusTrue(pageable).map(PacienteListDTO::new);
    }

    @PutMapping
    @Transactional
    public  void  atualizar (@RequestBody @Valid PacientePutDTO pacientePutDTO){
        var paciente  = pacienteRepository.getReferenceById(pacientePutDTO.id());
        paciente.atualizar(pacientePutDTO);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public  void deletar(@PathVariable Long id){
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.inativar();
    }

}
