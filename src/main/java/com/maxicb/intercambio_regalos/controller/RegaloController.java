package com.maxicb.intercambio_regalos.controller;

import com.maxicb.intercambio_regalos.dto.regalo.CrearRegaloDTO;
import com.maxicb.intercambio_regalos.dto.regalo.DatosRegaloDTO;
import com.maxicb.intercambio_regalos.service.RegaloService;
import com.maxicb.intercambio_regalos.service.RegaloServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/regalos")
public class RegaloController {

    private final RegaloService regaloService;

    public RegaloController(RegaloServiceImpl regaloService) {
        this.regaloService = regaloService;
    }

    @PostMapping
    public ResponseEntity<?> cargarRegalo(@RequestBody CrearRegaloDTO crearRegaloDTO) {
        if (crearRegaloDTO.getIdObsequiador().equals(crearRegaloDTO.getIdDestinatario())) {
            return new ResponseEntity<>("El obsequiador y el destinatario no pueden ser la misma persona.", HttpStatus.BAD_REQUEST);
        }
        DatosRegaloDTO datosRegaloDTO = regaloService.asignarRegalo(crearRegaloDTO);
        return new ResponseEntity<>(datosRegaloDTO, HttpStatus.CREATED);
    }

    @GetMapping("/obsequiador/{idObsequiador}")
    public ResponseEntity<List<DatosRegaloDTO>> obtenerRegalosPorObsequiador(@PathVariable Long idObsequiador){
        List<DatosRegaloDTO> regalos = regaloService.buscarRegaloPorObsequiador(idObsequiador);
        return new ResponseEntity<>(regalos, HttpStatus.OK);
    }

    @GetMapping("/{idObsequiador}/{idDestinatario}")
    public ResponseEntity<DatosRegaloDTO> mostrarRegalo(
            @PathVariable Long idObsequiador,
            @PathVariable Long idDestinatario){
        DatosRegaloDTO datosRegaloDTO = regaloService.mostrarRegalo(idObsequiador, idDestinatario);
        return new ResponseEntity<>(datosRegaloDTO, HttpStatus.OK);
    }

}
