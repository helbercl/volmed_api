package med.voll.api.interfaces.persistence;

import med.voll.api.domain.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente,Long> {
    Page<Paciente> findAllByStatusTrue(Pageable pageable);
}
