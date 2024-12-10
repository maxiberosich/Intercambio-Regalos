package com.maxicb.intercambio_regalos.service;

import com.maxicb.intercambio_regalos.dto.DatosUsuarioDTO;
import com.maxicb.intercambio_regalos.dto.regalo.CrearRegaloDTO;
import com.maxicb.intercambio_regalos.dto.regalo.DatosRegaloDTO;

import java.util.List;

public interface RegaloService {
    DatosRegaloDTO crearRegalo(CrearRegaloDTO crearRegaloDTO);
    List<DatosRegaloDTO> buscarRegaloPorObsequiador(Long idObsequiador);
    DatosRegaloDTO mostrarRegalo(Long idObsequiador, Long idDestinatario);
    DatosRegaloDTO asignarDestinatario(Long idRegalo);
}
