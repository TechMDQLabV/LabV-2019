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
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String descripcion;
    private String foto;
    private LocalDateTime fechaPublicacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuarioId", referencedColumnName = "id")
    @JsonIgnore
    private Usuario usuario;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "publicacion")
    private List<Comentario> comentarios;
}
