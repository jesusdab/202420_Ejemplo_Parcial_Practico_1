package co.edu.uniandes.dse.parcialprueba.services;

import co.edu.uniandes.dse.parcialprueba.entities.EspecialidadEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.BusinessLogicException;
import co.edu.uniandes.dse.parcialprueba.repositories.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EspecialidadService {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Transactional
    public EspecialidadEntity createEspecialidad(EspecialidadEntity especialidad) throws BusinessLogicException {
        // Validar que la descripción tenga al menos 10 caracteres
        if (especialidad.getDescripcion().length() < 10) {
            throw new BusinessLogicException("La descripción debe tener al menos 10 caracteres.");
        }
        return especialidadRepository.save(especialidad);
    }
}