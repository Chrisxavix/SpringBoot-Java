package mx.com.gm.dao;

import mx.com.gm.domain.Persona;
import org.springframework.data.repository.CrudRepository;

/* Al heredar de CrudRepository permite usa funciones de Crud, como eliminar, listar, guardar, etc */
public interface PersonaDao extends CrudRepository<Persona, Long> {

}
