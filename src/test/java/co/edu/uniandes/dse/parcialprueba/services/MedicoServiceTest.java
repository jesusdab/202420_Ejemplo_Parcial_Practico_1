package co.edu.uniandes.dse.parcialprueba.services;

import co.edu.uniandes.dse.parcialprueba.entities.MedicoEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.BusinessLogicException;
import co.edu.uniandes.dse.parcialprueba.repositories.MedicoRepository;
import co.edu.uniandes.dse.parcialprueba.services.MedicoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class MedicoServiceTest {

    @InjectMocks
    private MedicoService medicoService;

    @Mock
    private MedicoRepository medicoRepository;

    private MedicoEntity medico;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        medico = new MedicoEntity();
        medico.setNombre("Juan");
        medico.setApellido("Pérez");
        medico.setRegistroMedico("RM1234");
    }

    @Test
    public void testCreateMedicoCorrectamente() throws BusinessLogicException {
        when(medicoRepository.save(Mockito.any(MedicoEntity.class))).thenReturn(medico);
        
        MedicoEntity result = medicoService.createMedico(medico);
        
        assertNotNull(result);
        assertEquals("RM1234", result.getRegistroMedico());
    }

    @Test
    public void testCreateMedicoConError() {
        medico.setRegistroMedico("1234");  // No empieza con "RM"
        
        assertThrows(BusinessLogicException.class, () -> {
            medicoService.createMedico(medico);
        });
    }
}
