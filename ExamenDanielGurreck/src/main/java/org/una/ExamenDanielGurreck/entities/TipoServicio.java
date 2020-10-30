package org.una.ExamenDanielGurreck.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "exa_dan_tipos_servicios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TipoServicio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 30)
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoServicio")
    private List<ClienteTipoServicio> clientesTiposServicios = new ArrayList<>();

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {

    }

    @PreUpdate
    public void preUpdate() {

    }
}
