package com.maxicb.intercambio_regalos.dto.regalo;

public class CrearRegaloDTO {
    private Long idObsequiador;
    private Long idDestinatario;
    private String descripcion;

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
