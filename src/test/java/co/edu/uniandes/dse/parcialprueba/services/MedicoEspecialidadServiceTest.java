package co.edu.uniandes.dse.parcialprueba.services;

import co.edu.uniandes.dse.parcialprueba.entities.EspecialidadEntity;
import co.edu.uniandes.dse.parcialprueba.entities.MedicoEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.BusinessLogicException;
import co.edu.uniandes.dse.parcialprueba.repositories.EspecialidadRepository;
import co.edu.uniandes.dse.parcialprueba.repositories.MedicoRepository;
import co.edu.uniandes.dse.parcialprueba.services.MedicoEspecialidadService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class MedicoEspecialidadServiceTest {

    @InjectMocks
    private MedicoEspecialidadService medicoEspecialidadService;

    @Mock
    private MedicoRepository medicoRepository;

    @Mock
    private EspecialidadRepository especialidadRepository;

    private MedicoEntity medico;
    private EspecialidadEntity especialidad;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        
        medico = new MedicoEntity();
        medico.setId(1L);
        
        especialidad = new EspecialidadEntity();
        especialidad.setId(1L);
    }

    @Test
    public void testAddEspecialidadCorrectamente() throws BusinessLogicException {
        when(medicoRepository.findById(1L)).thenReturn(Optional.of(medico));
        when(especialidadRepository.findById(1L)).thenReturn(Optional.of(especialidad));
        
        medicoEspecialidadService.addEspecialidad(1L, 1L);
        
        assertTrue(medico.getEspecialidades().contains(especialidad));
    }

    @Test
    public void testAddEspecialidadConMedicoNoExistente() {
        when(medicoRepository.findById(1L)).thenReturn(Optional.empty());
        
        assertThrows(BusinessLogicException.class, () -> {
            medicoEspecialidadService.addEspecialidad(1L, 1L);
        });
    }

    @Test
    public void testAddEspecialidadConEspecialidadNoExistente() {
        when(medicoRepository.findById(1L)).thenReturn(Optional.of(medico));
        when(especialidadRepository.findById(1L)).thenReturn(Optional.empty());
        
        assertThrows(BusinessLogicException.class, () -> {
            medicoEspecialidadService.addEspecialidad(1L, 1L);
        });
    }
}