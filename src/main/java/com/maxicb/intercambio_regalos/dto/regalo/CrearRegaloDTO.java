package com.maxicb.intercambio_regalos.dto.regalo;

public class CrearRegaloDTO {
    private Long idObsequiador;
    private String descripcion;

    public Long getIdObsequiador() {
        return idObsequiador;
    }

    public void setIdObsequiador(Long idObsequiador) {
        this.idObsequiador = idObsequiador;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
