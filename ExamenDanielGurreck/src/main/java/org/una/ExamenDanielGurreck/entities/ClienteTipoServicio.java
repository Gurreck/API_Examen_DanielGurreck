package org.una.ExamenDanielGurreck.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "exa_dan_clientes_tipos_servicios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClienteTipoServicio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="exa_dan_clientes_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name="exa_dan_tipos_servicios_id")
    private TipoServicio tipoServicio;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteTipoServicio")
    private List<Membresia> membresias = new ArrayList<>();


    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {

    }

    @PreUpdate
    public void preUpdate() {

    }
}
