package com.maxicb.intercambio_regalos.repository;

import com.maxicb.intercambio_regalos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
