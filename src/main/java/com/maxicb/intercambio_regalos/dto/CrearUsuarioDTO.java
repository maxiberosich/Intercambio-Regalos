package com.maxicb.intercambio_regalos.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class CrearUsuarioDTO {

        @NotBlank(message = "Nombre de Usuario no puede estar en blanco")
        private String nombreUsuario;

        @NotBlank(message = "El email no puede estar en blanco")
        @Email(message = "El email debe tener un formato válido")
        private String email;

        public CrearUsuarioDTO() {
        }

        public CrearUsuarioDTO(String nombreUsuario, String email) {
                this.nombreUsuario = nombreUsuario;
                this.email = email;
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
