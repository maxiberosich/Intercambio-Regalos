package com.maxicb.intercambio_regalos.repository;

import com.maxicb.intercambio_regalos.model.Regalo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegaloRepository extends JpaRepository<Regalo, Long> {
    List<Regalo> findByObsequiadorIdUsuario(Long id_obsequiador);

    Optional<Regalo> findByObsequiadorIdUsuarioAndDestinatarioIdUsuario(Long id_obsequiador, Long id_destinatario);
}
