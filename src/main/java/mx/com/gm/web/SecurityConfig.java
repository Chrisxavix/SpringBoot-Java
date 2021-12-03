package mx.com.gm.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
/* @EnableWebSecurity: Habilitar la seguridad web */
@EnableWebSecurity
/* Extender de WebSecurityConfigurerAdapter para configurar los usuarios */
public class SecurityConfig extends WebSecurityConfigurerAdapter {


}
