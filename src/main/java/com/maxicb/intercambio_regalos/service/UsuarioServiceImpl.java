package com.maxicb.intercambio_regalos.service;

import com.maxicb.intercambio_regalos.dto.ActualizarUsuarioDTO;
import com.maxicb.intercambio_regalos.dto.CrearUsuarioDTO;
import com.maxicb.intercambio_regalos.dto.DatosUsuarioDTO;
import com.maxicb.intercambio_regalos.model.Usuario;
import com.maxicb.intercambio_regalos.repository.UsuarioRepository;
import com.maxicb.intercambio_regalos.util.ModelMapperUtil;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    private final UsuarioRepository usuarioRepository;
    private final ModelMapperUtil modelMapperUtil;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, ModelMapperUtil modelMapperUtil) {
        this.usuarioRepository = usuarioRepository;
        this.modelMapperUtil = modelMapperUtil;
    }

    @Override
    public DatosUsuarioDTO registrarUsuario(CrearUsuarioDTO crearUsuarioDTO){
        if (usuarioRepository.existsByEmail(crearUsuarioDTO.getEmail())){
            return null;
        }

        Usuario usuario = modelMapperUtil.convertToEntity(crearUsuarioDTO, Usuario.class);
        usuario = usuarioRepository.save(usuario);
        return modelMapperUtil.convertToDto(usuario, DatosUsuarioDTO.class);
    }

    @Override
    public List<DatosUsuarioDTO> mostrarTodosLosUsuarios(){
        List<Usuario> listaUsuarios = usuarioRepository.findAll();
        return modelMapperUtil.convertToDtoList(listaUsuarios, DatosUsuarioDTO.class);
    }

    @Override
    public DatosUsuarioDTO mostrarUsuarioPorId(Long idUsuario){
        Usuario usuarioEncontrado = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new EntityNotFoundException(("Usuario no encontrado")));
        return modelMapperUtil.convertToDto(usuarioEncontrado, DatosUsuarioDTO.class);
    }

    @Override
    public DatosUsuarioDTO actualizarUsuario(Long idUsuario, ActualizarUsuarioDTO actualizarUsuarioDTO){
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException(("Usuario no encontrado")));

        if (actualizarUsuarioDTO.getNombreUsuario() != null) {
            usuario.setNombreUsuario(actualizarUsuarioDTO.getNombreUsuario());
        }
        if (actualizarUsuarioDTO.getEmail() != null) {
            usuario.setEmail(actualizarUsuarioDTO.getEmail());
        }

        usuario = usuarioRepository.save(usuario);
        return modelMapperUtil.convertToDto(usuario, DatosUsuarioDTO.class);
    }

    @Override
    public void eliminarUsuario(Long idUsuario){
        usuarioRepository.deleteById(idUsuario);
    }

}
