package utn.primerParcial.primerParcial.controller;

import com.sun.istack.internal.NotNull;
import utn.primerParcial.primerParcial.model.Comentario;
import utn.primerParcial.primerParcial.model.Publicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import utn.primerParcial.primerParcial.repository.ComentarioRepository;
import utn.primerParcial.primerParcial.repository.PublicacionRepository;
import utn.primerParcial.primerParcial.repository.UsuarioRepository;

import java.time.LocalDateTime;

@RequestMapping("/comentarios")
@RestController
public class ComentarioController {
    private static final String COMENTARIO_NOT_FOUND = "Don't exist Comentario with id: %s";
    private static final String PUBLICACION_NOT_FOUND = "Don't exist Publicacion with id: %s";
    @Autowired
    UsuarioRepository usuarioRepository;
    PublicacionRepository publicacionRepository;
    ComentarioRepository comentarioRepository;

    @GetMapping("/{id}")
    public Comentario getComentario(@PathVariable("id") Integer id) {
        return comentarioRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, COMENTARIO_NOT_FOUND));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteComentario(@PathVariable("id") final @NotNull Integer id) {
        comentarioRepository.deleteById(id);
    }

    @PostMapping("/[id]/comentario")
    public void comentario(@PathVariable final Integer id, @RequestBody final Comentario comentario){

        Publicacion p = publicacionRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format(PUBLICACION_NOT_FOUND, id)));
        comentario.setPublicacion(p);
        comentario.setFecha(LocalDateTime.now());
        comentarioRepository.save(comentario);
    }

}
