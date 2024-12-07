CREATE TABLE IF NOT EXISTS regalo (
    id_regalo BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_obsequiador BIGINT NOT NULL,
    id_destinatario BIGINT NOT NULL,
    descripcion VARCHAR(255),
    FOREIGN KEY (id_obsequiador) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_destinatario) REFERENCES usuario(id_usuario)
);