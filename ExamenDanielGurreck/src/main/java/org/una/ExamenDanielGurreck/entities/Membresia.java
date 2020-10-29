package org.una.ExamenDanielGurreck.entities;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "exa_dan_membresias")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Membresia implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer periodicidad;

    @Column
    private Float monto;

    @Column(name = "descripcion", length = 100)
    private String descripcion;

    @Column
    private boolean estado;

    @Column(name = "fecha_registro", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaRegistro;

    @ManyToOne
    @JoinColumn(name="exa_dan_clientes_tipos_servicios_id")
    private ClienteTipoServicio clienteTipoServicio;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "membresia")
    private List<CobroPendiente> cobrosPendientes = new ArrayList<>();

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
        estado=true;
        fechaRegistro = new Date();
    }

    @PreUpdate
    public void preUpdate() {

    }
}
