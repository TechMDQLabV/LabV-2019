package model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublicacionDTO {
    private Integer id;
    private String titulo;
    private String titular;
    private Integer cantidadComentarios;

    @JoinColumn(name = "titulo", referencedColumnName = "titulo")
    @JoinColumn(name = "id", referencedColumnName = "id")
    @JsonIgnore
    private Publicacion publicacion;

    @JoinColumn(name = "titular", referencedColumnName = "nombre")
    @JsonIgnore
    private Usuario usuario;

}
