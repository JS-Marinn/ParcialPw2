package com.vehiculos.servicio;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.vehiculos.controlador.dto.UsuarioRegistroDTO;
import com.vehiculos.modelo.Usuario;


public interface UsuarioServicio extends UserDetailsService{

	public Usuario guardar(UsuarioRegistroDTO registroDTO);
	
	public List<Usuario> listarUsuarios();
	
}
