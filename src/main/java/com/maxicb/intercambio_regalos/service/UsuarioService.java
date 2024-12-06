package com.maxicb.intercambio_regalos.service;

import com.maxicb.intercambio_regalos.dto.ActualizarUsuarioDTO;
import com.maxicb.intercambio_regalos.dto.CrearUsuarioDTO;
import com.maxicb.intercambio_regalos.dto.DatosUsuarioDTO;

import java.util.List;

public interface UsuarioService {
    DatosUsuarioDTO registrarUsuario(CrearUsuarioDTO crearUsuarioDTO);
    DatosUsuarioDTO mostrarUsuarioPorId(Long idUsuario);
    List<DatosUsuarioDTO> mostrarTodosLosUsuarios();
    DatosUsuarioDTO actualizarUsuario(Long idUsuario, ActualizarUsuarioDTO actualizarUsuarioDTO);
    void eliminarUsuario(Long idUsuario);
}
