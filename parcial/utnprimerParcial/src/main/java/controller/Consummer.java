package controller;

import model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ConsummerService;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/consummer")
public class Consummer {

    @Autowired
    private ConsummerService consummerService;

    @GetMapping("/allContent")
    public ResponseEntity<?> getAsync() {
        CompletableFuture<List> resultUsuarios = consummerService.usuarios();
        CompletableFuture<List> resultPublicaciones = consummerService.publicaciones();
        CompletableFuture<List> resultComentarios = consummerService.comentarios();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(resultUsuarios.toString()+resultPublicaciones.toString()+resultComentarios.toString());
    }
}
