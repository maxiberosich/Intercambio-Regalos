package com.maxicb.intercambio_regalos.service;

import com.maxicb.intercambio_regalos.dto.DatosUsuarioDTO;
import com.maxicb.intercambio_regalos.dto.regalo.CrearRegaloDTO;
import com.maxicb.intercambio_regalos.dto.regalo.DatosRegaloDTO;
import com.maxicb.intercambio_regalos.model.Regalo;
import com.maxicb.intercambio_regalos.model.Usuario;
import com.maxicb.intercambio_regalos.repository.RegaloRepository;
import com.maxicb.intercambio_regalos.util.ModelMapperUtil;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class RegaloServiceImpl implements RegaloService{

    private final RegaloRepository regaloRepository;
    private final UsuarioService usuarioService;
    private final ModelMapperUtil modelMapperUtil;

    public RegaloServiceImpl(RegaloRepository regaloRepository, UsuarioService usuarioService, ModelMapperUtil modelMapperUtil) {
        this.regaloRepository = regaloRepository;
        this.usuarioService = usuarioService;
        this.modelMapperUtil = modelMapperUtil;
    }

    @Override
    public DatosRegaloDTO crearRegalo(CrearRegaloDTO crearRegaloDTO) {
        DatosUsuarioDTO obsequiador = usuarioService.mostrarUsuarioPorId(crearRegaloDTO.getIdObsequiador());

        Regalo regalo = new Regalo();
        regalo.setObsequiador(modelMapperUtil.convertToEntity(obsequiador, Usuario.class));
        regalo.setDescripcion(crearRegaloDTO.getDescripcion());
        regalo = regaloRepository.save(regalo);

        return modelMapperUtil.convertToDto(regalo, DatosRegaloDTO.class);
    }

    @Override
    public List<DatosRegaloDTO> buscarRegaloPorObsequiador(Long idObsequiador) {
        List<Regalo> regalos = regaloRepository.findByObsequiadorIdUsuario(idObsequiador);
        return modelMapperUtil.convertToDtoList(regalos, DatosRegaloDTO.class);
    }

    @Override
    public DatosRegaloDTO mostrarRegalo(Long idObsequiador, Long idDestinatario) {
        Regalo regalo = regaloRepository.findByObsequiadorIdUsuarioAndDestinatarioIdUsuario(idObsequiador, idDestinatario)
                .orElseThrow(() -> new EntityNotFoundException("Asignación no encontrada"));
        return modelMapperUtil.convertToDto(regalo, DatosRegaloDTO.class);
    }

    @Override
    public DatosRegaloDTO asignarDestinatario(Long idRegalo) {
        Regalo regalo = regaloRepository.findById(idRegalo)
                .orElseThrow(() -> new EntityNotFoundException("Regalo no encontrado"));

        if (regalo.getDestinatario() == null){
            List<DatosUsuarioDTO> participantes = usuarioService.mostrarTodosLosUsuarios()
                    .stream()
                    .filter(datosUsuarioDTO -> !datosUsuarioDTO.getIdUsuario().equals(idRegalo))
                    .collect(Collectors.toList());

            if (participantes.isEmpty()){
                throw new IllegalStateException("No hay destinatarios disponible");
            }

            DatosUsuarioDTO usuarioDTO = participantes.get(new Random().nextInt(participantes.size()));
            regalo.setDestinatario(modelMapperUtil.convertToEntity(usuarioDTO, Usuario.class));
            regalo = regaloRepository.save(regalo);
            return modelMapperUtil.convertToDto(regalo, DatosRegaloDTO.class);
        }else {
            return null;
        }
    }


}
