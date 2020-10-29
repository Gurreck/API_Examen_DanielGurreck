package org.una.ExamenDanielGurreck.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClienteDTO {

    private Long id;
    private String nombreCompleto;
    private String cedula;
    private String telefono;
    private boolean estado;
}
