package repository;

import model.Publicacion;
import model.PublicacionDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacionDTORepository  extends JpaRepository<PublicacionDTO, Integer> {
}
