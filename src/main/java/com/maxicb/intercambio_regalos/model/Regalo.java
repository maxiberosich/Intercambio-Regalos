package com.maxicb.intercambio_regalos.model;

import jakarta.persistence.*;

@Entity
public class Regalo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegalo;

    @ManyToOne
    @JoinColumn(name = "id_obsequiador", nullable = false)
    private Usuario obsequiador;

    @ManyToOne
    @JoinColumn(name = "id_destinatario", nullable = false)
    private Usuario destinatario;
    private String descripcion;

    public Regalo() {
    }

    public Regalo(Long idRegalo, Usuario obsequiador, Usuario destinatario, String descripcion) {
        this.idRegalo = idRegalo;
        this.obsequiador = obsequiador;
        this.destinatario = destinatario;
        this.descripcion = descripcion;
    }

    public Long getIdRegalo() {
        return idRegalo;
    }

    public void setIdRegalo(Long idRegalo) {
        this.idRegalo = idRegalo;
    }

    public Usuario getObsequiador() {
        return obsequiador;
    }

    public void setObsequiador(Usuario obsequiador) {
        this.obsequiador = obsequiador;
    }

    public Usuario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Usuario destinatario) {
        this.destinatario = destinatario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
