package com.maxicb.intercambio_regalos.dto.regalo;

public class DatosRegaloDTO {
    private Long idRegalo;
    private Long idObsequiador;
    private Long idDestinatario;
    private String descripcion;

    public Long getIdRegalo() {
        return idRegalo;
    }

    public void setIdRegalo(Long idRegalo) {
        this.idRegalo = idRegalo;
    }

    public Long getIdObsequiador() {
        return idObsequiador;
    }

    public void setIdObsequiador(Long idObsequiador) {
        this.idObsequiador = idObsequiador;
    }

    public Long getIdDestinatario() {
        return idDestinatario;
    }

    public void setIdDestinatario(Long idDestinatario) {
        this.idDestinatario = idDestinatario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
