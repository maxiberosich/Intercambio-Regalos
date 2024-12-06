package com.maxicb.intercambio_regalos.dto;

public class DatosUsuarioDTO{

    private Long idUsuario;
    private String nombreUsuario;
    private String email;

    public DatosUsuarioDTO() {
    }

    public DatosUsuarioDTO(Long idUsuario, String nombreUsuario, String email) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
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
}
