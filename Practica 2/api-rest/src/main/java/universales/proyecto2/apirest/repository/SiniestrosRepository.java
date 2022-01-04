package universales.proyecto2.apirest.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import universales.proyecto2.apirest.entity.Siniestros;

@Repository("siniestrosRepository")
public interface SiniestrosRepository extends JpaRepository <Siniestros, Serializable>{
    
    public List<Siniestros> findByAceptadoLike(String aceptado);

    public List<Siniestros> findByAceptadoNotLike(String aceptado);

    public List<Siniestros> findByIndemnizacionLike(String indemnizacion);
}
