package utn.primerParcial.primerParcial.controller;


import com.sun.istack.internal.NotNull;
import utn.primerParcial.primerParcial.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import utn.primerParcial.primerParcial.repository.UsuarioRepository;

import java.net.InetSocketAddress;
import java.util.List;
import java.util.Map;

@RequestMapping("/usuario")
@RestController
public class UsuarioController {
    private static final String USER_NOT_FOUND = "Don't exist User with id: %s";

    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping("/save")
    public void addUsuario(@RequestHeader HttpHeaders headers, @RequestBody final Usuario u){
        u.setBrowser(String.format("Browser: %s", headers.get("user_agents")));
        usuarioRepository.save(u);
    }

    @GetMapping("/all")
    public List<Usuario> getAll(){
        return usuarioRepository.findAll();
    }

    @GetMapping("/{name}")
    public Usuario findByName(@PathVariable final String name){
        return usuarioRepository.findByName(name);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUsuario(@PathVariable("id") final @NotNull Integer id) {
        usuarioRepository.deleteById(id);
    }

    @PostMapping("/{id}/usuario")
    public void editUsuario(@PathVariable("id") Integer id, @RequestBody final Usuario u) {
        Usuario userOld = usuarioRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, String.format(USER_NOT_FOUND, id)));
        userOld.setApellido(u.getApellido());
        userOld.setBrowser(u.getBrowser());
        usuarioRepository.save(u);
    }

}
