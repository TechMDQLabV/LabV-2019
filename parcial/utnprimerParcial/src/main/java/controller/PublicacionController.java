package controller;

import com.sun.istack.internal.NotNull;
import model.Publicacion;
import model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import repository.PublicacionRepository;
import repository.UsuarioRepository;

import java.util.List;

@RequestMapping("/publicaciones")
@RestController
public class PublicacionController {
    private static final String USER_NOT_FOUND = "Don't exist User with id: %s";
    private static final String PUBLICACION_NOT_FOUND = "Don't exist Publicacion with id: %s";

    @Autowired
    UsuarioRepository usuarioRepository;
    PublicacionRepository publicacionRepository;

    @GetMapping("/all")
    public List<Publicacion> getAll(){
        return publicacionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Publicacion getPublicacion(@PathVariable("id") Integer id) {
        return publicacionRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, PUBLICACION_NOT_FOUND));
    }

    @DeleteMapping(value = "/{id}")
    public void deletePublicacion(@PathVariable("id") final @NotNull Integer id) {
        publicacionRepository.deleteById(id);
    }

    @PostMapping("/[id]/publicacion")
    public void publicacion(@PathVariable final Integer id, @RequestBody final Publicacion publicacion){

        Usuario u = usuarioRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format(USER_NOT_FOUND, id)));
        publicacion.setUsuario(u);
        publicacionRepository.save(publicacion);
    }

}
