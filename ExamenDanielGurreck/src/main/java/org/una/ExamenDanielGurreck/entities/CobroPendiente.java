package org.una.ExamenDanielGurreck.entities;

import java.io.Serializable;
import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "exa_dan_cobros_pendientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CobroPendiente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer anio;

    @Column
    private Integer periodo;

    @Column
    private Float monto;

    @Column(name = "fecha_vencimiento", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.PUBLIC)
    private Date fechaVencimiento;

    @ManyToOne
    @JoinColumn(name = "exa_dan_mebresias_id")
    private Membresia membresia;

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {
    }

    @PreUpdate
    public void preUpdate() {

    }
}