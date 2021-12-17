package mx.com.gm.web;

import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import mx.com.gm.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
/* Para los logs que lanza Spring, parte de lombok */
@Slf4j
public class ControladorInicio {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user){
        var personas = personaService.listarPersonas();
        log.info("Ejecutando el controlador Spring MVC");
        log.info("Usuario habilitado" + user);
        model.addAttribute("personas", personas);
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Persona persona) {
        /* Devuelve el template de modificar.html */
        return "modificar";
    }

    /* El path del PostMapping debe ser igual al declarado en el formulario html */
    /* @Valid: Recuperar los valores para validar el formulario */
    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores) {
        if(errores.hasErrors()) {
            return "modificar";
        }
        personaService.guardar(persona);
        System.out.println("Se ha guardado: " + persona);
        /* Redirigir a la pantalla que se desea, en este caso al inicio */
        return "redirect:/";
    }

    /* @GetMapping porque desprende desde un enlace */
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model) {
        persona = personaService.encontrarPersona(persona);
        System.out.println("Se ha guardado: " + persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }

    @GetMapping("/eliminar")
    public String eliminar(Persona persona) {
        personaService.eliminar(persona);
        System.out.println("Se ha eliminado: " + persona);
        return "redirect:/";
    }
}
