package utn.primerParcial.primerParcial.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Descripcion;
    private LocalDateTime fecha;
    private Usuario owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publicacionId", referencedColumnName = "id")
    @JsonIgnore
    private Publicacion publicacion;
}
