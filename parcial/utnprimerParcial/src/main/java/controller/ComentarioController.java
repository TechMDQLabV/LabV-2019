package controller;

import com.sun.istack.internal.NotNull;
import model.Comentario;
import model.Publicacion;
import model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import repository.ComentarioRepository;
import repository.PublicacionRepository;
import repository.UsuarioRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Properties;

@RequestMapping("/comentarios")
@RestController
public class ComentarioController {
    private static final String COMENTARIO_NOT_FOUND = "Don't exist Comentario with id: %s";
    private static final String PUBLICACION_NOT_FOUND = "Don't exist Publicacion with id: %s";
    @Autowired
    UsuarioRepository usuarioRepository;
    PublicacionRepository publicacionRepository;
    ComentarioRepository comentarioRepository;

    @GetMapping("/all")
    public List<Comentario> getAll(){
        return comentarioRepository.findAll();
    }

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

    @Scheduled(fixedDelay = 600000)
    public void borrarComentariosViejos() {
        Properties tiempo = new Properties();
        //tiempo.load("/SimulacroParcial/src/main/resources/application.properties");
        String t = tiempo.getProperty("tiempo");
        for (Comentario c : comentarioRepository.findAll()) {
            if (LocalDateTime.now().compareTo(c.getFecha()) > Integer.valueOf(t)) {
                comentarioRepository.delete(c);
            }
        }
    }
}