package co.edu.uniandes.dse.parcialprueba.services;

import co.edu.uniandes.dse.parcialprueba.entities.EspecialidadEntity;
import co.edu.uniandes.dse.parcialprueba.entities.MedicoEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.BusinessLogicException;
import co.edu.uniandes.dse.parcialprueba.repositories.EspecialidadRepository;
import co.edu.uniandes.dse.parcialprueba.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MedicoEspecialidadService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Transactional
    public void addEspecialidad(Long medicoId, Long especialidadId) throws BusinessLogicException {
        // Validar que el médico exista
        Optional<MedicoEntity> medico = medicoRepository.findById(medicoId);
        if (medico.isEmpty()) {
            throw new BusinessLogicException("El médico con el ID dado no existe.");
        }

        // Validar que la especialidad exista
        Optional<EspecialidadEntity> especialidad = especialidadRepository.findById(especialidadId);
        if (especialidad.isEmpty()) {
            throw new BusinessLogicException("La especialidad con el ID dado no existe.");
        }

        // Asociar la especialidad al médico
        MedicoEntity medicoEntity = medico.get();
        medicoEntity.getEspecialidades().add(especialidad.get());
        medicoRepository.save(medicoEntity);
    }
}