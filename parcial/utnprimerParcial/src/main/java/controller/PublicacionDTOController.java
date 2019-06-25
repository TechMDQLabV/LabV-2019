package controller;


import model.Publicacion;
import model.PublicacionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import repository.PublicacionDTORepository;
import repository.PublicacionRepository;
import repository.UsuarioRepository;

@RequestMapping("/publicaciones")
@RestController
public class PublicacionDTOController {
    private static final String USER_NOT_FOUND = "Don't exist User with id: %s";
    private static final String PUBLICACION_NOT_FOUND = "Don't exist Publicacion with id: %s";

    @Autowired
    UsuarioRepository usuarioRepository;
    PublicacionRepository publicacionRepository;
    PublicacionDTORepository publicacionDTORepository;

    @GetMapping("/{id}")
    public PublicacionDTO getPublicacionDTO(@PathVariable("id") Integer id) {
        return publicacionDTORepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, PUBLICACION_NOT_FOUND));
    }


}
