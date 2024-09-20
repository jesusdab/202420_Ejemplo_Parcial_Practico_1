package co.edu.uniandes.dse.parcialprueba.services;

import co.edu.uniandes.dse.parcialprueba.entities.MedicoEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.BusinessLogicException;
import co.edu.uniandes.dse.parcialprueba.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Transactional
    public MedicoEntity createMedico(MedicoEntity medico) throws BusinessLogicException {
        // Validar que el registro médico comience con "RM"
        if (!medico.getRegistroMedico().startsWith("RM")) {
            throw new BusinessLogicException("El registro médico debe comenzar con 'RM'.");
        }
        return medicoRepository.save(medico);
    }
}
