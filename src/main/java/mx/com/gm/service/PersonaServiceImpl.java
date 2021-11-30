package mx.com.gm.service;

import mx.com.gm.dao.PersonaDao;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/* Para que Spring reconozca una clase de servicio se agrega la notación @servide */
@Service
public class PersonaServiceImpl implements PersonaService {

    /* Inyectar una instancia de tipo PersonaDAO */
    @Autowired
    private PersonaDao personaDao;

    @Override
    /* Transaccional solo de lectura */
    @Transactional(readOnly = true)
    public List<Persona> listarPersonas() {
        /* Se realiza un cast, pasar de objeto a lista */
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
        return personaDao.findById(persona.getIdPersona()).orElse(null);
    }
}
