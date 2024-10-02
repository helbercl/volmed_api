package med.voll.api.controller;
import jakarta.validation.Valid;
import med.voll.api.domain.Medico;
import med.voll.api.dto.medico.MedicoDTO;
import med.voll.api.dto.medico.MedicoListDTO;
import med.voll.api.dto.medico.MedicoPutDTO;
import med.voll.api.interfaces.persistence.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired //Injeção e gerenciamento pelo spring
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public void inserir(@RequestBody @Valid MedicoDTO medicoDTO){
        try {
            medicoRepository.save(new Medico(medicoDTO));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //validation modulo do spring boot com o modulo do beanValidation

    @GetMapping
    public Page<MedicoListDTO> listar(@PageableDefault(size = 25, sort = {"nome"}) Pageable pageable){
        return medicoRepository.findAllByStatusTrue(pageable).map(MedicoListDTO::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid MedicoPutDTO medicoPutDTO){
        //So pode atualizar nome telefone e endereço
        var medico = medicoRepository.getReferenceById(medicoPutDTO.id());
        medico.atualizar(medicoPutDTO);
    }

    //Parametro dinamico entre chaves
    @DeleteMapping("/{id}")
    @Transactional
    //Variavel do path da url
    public void deletar(@PathVariable Long id){
        /*Remoção não logica
        medicoRepository.deleteById(id);*/

        //Remoção Logica
        var medico = medicoRepository.getReferenceById(id);
        medico.deletar();
    }
}
