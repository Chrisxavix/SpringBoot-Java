package mx.com.gm.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/* Usar @Data ayuda en el uso de getters, setters, toString
   Dependencia de Lombok */
@Data
@Entity
/* Para darle el nombre a la tabla, haciendo coincidir con la de la base de datos */
@Table(name = "persona")
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;
    /* @NotEmpty: valida que no puede contener el valor vacío */
    /* @NotNull: valida que no sea nulo, y no valida la cadena vacía */
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String apellido;
    @NotEmpty
    @Email
    private String email;
    private String telefono;
}
