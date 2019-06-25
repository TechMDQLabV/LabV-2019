package service;

import controller.ComentarioController;
import controller.PublicacionController;
import controller.UsuarioController;
import model.Comentario;
import model.Publicacion;
import model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import repository.ComentarioRepository;
import repository.PublicacionRepository;
import repository.UsuarioRepository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class ConsummerService {

    @Autowired
    UsuarioController usuarioController;
    PublicacionController publicacionController;
    ComentarioController comentarioController;

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<List<Usuario>> usuarios() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(usuarioController.getAll());
    }

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<List<Publicacion>> publicaciones() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(publicacionController.getAll());
    }

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<List<Comentario>> comentarios() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(comentarioController.getAll());
    }
}
