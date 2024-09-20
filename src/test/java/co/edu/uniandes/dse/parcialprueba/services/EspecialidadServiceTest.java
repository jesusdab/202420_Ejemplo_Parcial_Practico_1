package co.edu.uniandes.dse.parcialprueba.services;

import co.edu.uniandes.dse.parcialprueba.entities.EspecialidadEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.BusinessLogicException;
import co.edu.uniandes.dse.parcialprueba.repositories.EspecialidadRepository;
import co.edu.uniandes.dse.parcialprueba.services.EspecialidadService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class EspecialidadServiceTest {

    @InjectMocks
    private EspecialidadService especialidadService;

    @Mock
    private EspecialidadRepository especialidadRepository;

    private EspecialidadEntity especialidad;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        especialidad = new EspecialidadEntity();
        especialidad.setNombre("Cardiología");
        especialidad.setDescripcion("Especialidad del corazón");
    }

    @Test
    public void testCreateEspecialidadCorrectamente() throws BusinessLogicException {
        when(especialidadRepository.save(Mockito.any(EspecialidadEntity.class))).thenReturn(especialidad);
        
        EspecialidadEntity result = especialidadService.createEspecialidad(especialidad);
        
        assertNotNull(result);
        assertEquals("Cardiología", result.getNombre());
    }

    @Test
    public void testCreateEspecialidadConError() {
        especialidad.setDescripcion("Corta");  // Menos de 10 caracteres
        
        assertThrows(BusinessLogicException.class, () -> {
            especialidadService.createEspecialidad(especialidad);
        });
    }
}