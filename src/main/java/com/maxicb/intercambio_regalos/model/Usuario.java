package com.maxicb.intercambio_regalos.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    private String nombreUsuario;
    private String email;
    @OneToMany(mappedBy = "obsequiador")
    private List<Regalo> regalos;

    public Usuario() {
    }

    public Usuario(Long idUsuario, String nombreUsuario, String email, List<Regalo> regalos) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.regalos = regalos;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Regalo> getRegalos() {
        return regalos;
    }

    public void setRegalos(List<Regalo> regalos) {
        this.regalos = regalos;
    }
}
