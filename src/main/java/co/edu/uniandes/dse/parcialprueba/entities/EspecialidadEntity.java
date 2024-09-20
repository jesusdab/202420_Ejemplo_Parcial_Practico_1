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
 * Clase que representa una especialidad en la persistencia.
 */
@Data
@Entity
public class EspecialidadEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;

    // Relación con MedicoEntity
    @PodamExclude
    @ManyToMany
    private List<MedicoEntity> medicos = new ArrayList<>();
}