package org.una.ExamenDanielGurreck.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
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

    @Column(name = "periodicidad", length = 15)
    private String periodicidad;

    @Column
    private Float monto;

    @Column(name = "descripcion", length = 100)
    private String descripcion;

    private static final long serialVersionUID = 1L;

    @PrePersist
    public void prePersist() {

    }

    @PreUpdate
    public void preUpdate() {

    }
}
