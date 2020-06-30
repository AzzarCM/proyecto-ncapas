package com.uca.capas.proyecto.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/registroUsuario", "/login").permitAll()
                .antMatchers("/index").hasAnyAuthority("Administrador", "Coordinador")
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .usernameParameter("username")
                .passwordParameter("password")
                //.defaultSuccessUrl("/registroUsuario")
                .successHandler((req,res,auth)->{    //Success handler invoked after successful authentication
                    for (GrantedAuthority authority : auth.getAuthorities()) {
                        System.out.println(authority.getAuthority());
                    }


                    res.sendRedirect("/index"); // Redirect user to index/home page
                })
                .failureHandler((req,res,exp)->{  // Failure handler invoked after authentication failure
                    String errMsg="";

                    if(exp.getClass().isAssignableFrom(BadCredentialsException.class)){
                        System.out.println("Invalid username or password.");
                    }else{
                        System.out.println("Unknown error - "+exp.getMessage());
                    }
                    res.sendRedirect("/login?error"); // Redirect user to login page with error message.
                })
                //.failureUrl("/login?error")
                .and()
                .logout().logoutSuccessUrl("/login?logout")
                .and()
                .sessionManagement()
                .maximumSessions(1)
                .maxSessionsPreventsLogin(true);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(4);
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT nombre_usuario as username, contrasenia as password, estado as enabled FROM usuario WHERE nombre_usuario=?")
                .authoritiesByUsernameQuery("SELECT u.nombre_usuario as username, r.nombre as role FROM usuario u, rol r WHERE u.id_rol = r.id_rol AND u.nombre_usuario = ?")
                .passwordEncoder(passwordEncoder());
    }

    
}
