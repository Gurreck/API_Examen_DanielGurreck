package org.una.ExamenDanielGurreck.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MembresiaDTO {

    private Long id;
    private String periodicidad;
    private Float monto;
    private String descripcion;

}
