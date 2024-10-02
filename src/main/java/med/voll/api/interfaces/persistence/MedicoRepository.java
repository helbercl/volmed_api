package med.voll.api.interfaces.persistence        ;


import med.voll.api.domain.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MedicoRepository  extends JpaRepository<Medico,Long> {
    Page<Medico> findAllByStatusTrue(Pageable pageable);
}
