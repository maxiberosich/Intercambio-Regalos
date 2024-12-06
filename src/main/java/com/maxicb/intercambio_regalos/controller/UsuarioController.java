package com.maxicb.intercambio_regalos.controller;

import com.maxicb.intercambio_regalos.dto.ActualizarUsuarioDTO;
import com.maxicb.intercambio_regalos.dto.CrearUsuarioDTO;
import com.maxicb.intercambio_regalos.dto.DatosUsuarioDTO;
import com.maxicb.intercambio_regalos.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<DatosUsuarioDTO> registrarUsuario(
            @RequestBody @Valid CrearUsuarioDTO crearUsuarioDTO){
        DatosUsuarioDTO datosUsuarioDTO = usuarioService.registrarUsuario(crearUsuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(datosUsuarioDTO);
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<DatosUsuarioDTO> mostrarUsuarioPorId(@PathVariable Long idUsuario){
        DatosUsuarioDTO datosUsuarioDTO = usuarioService.mostrarUsuarioPorId(idUsuario);
        return ResponseEntity.ok(datosUsuarioDTO);
    }

    @GetMapping
    public ResponseEntity<List<DatosUsuarioDTO>> mostrarTodosLosUsuarios(){
        List<DatosUsuarioDTO> usuarios = usuarioService.mostrarTodosLosUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @PutMapping("/{idUsuario}")
    public ResponseEntity<DatosUsuarioDTO> actualizarUsuario(
            @PathVariable Long idUsuario,
            @RequestBody @Valid ActualizarUsuarioDTO actualizarUsuarioDTO){
        DatosUsuarioDTO usuarioDTO = usuarioService.actualizarUsuario(idUsuario, actualizarUsuarioDTO);
        return ResponseEntity.ok(usuarioDTO);
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long idUsuario){
        usuarioService.eliminarUsuario(idUsuario);
        return ResponseEntity.noContent().build();
    }

}
