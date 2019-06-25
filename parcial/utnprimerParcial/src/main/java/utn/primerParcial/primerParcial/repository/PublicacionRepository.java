package utn.primerParcial.primerParcial.repository;

import utn.primerParcial.primerParcial.model.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacionRepository  extends JpaRepository<Publicacion, Integer> {

}
