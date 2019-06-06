package repository;

import model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository   extends JpaRepository<Comentario, Integer> {

}
