package co.edu.uniandes.dse.parcialprueba.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un médico en la persistencia.
 */
@Data
@Entity
public class MedicoEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String registroMedico;

    // Relación con EspecialidadEntity
    @PodamExclude
    @ManyToMany(mappedBy = "medicos")
    private List<EspecialidadEntity> especialidades = new ArrayList<>();
}