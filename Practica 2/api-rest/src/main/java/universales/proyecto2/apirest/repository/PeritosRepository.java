package universales.proyecto2.apirest.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import universales.proyecto2.apirest.entity.Peritos;

@Repository("peritosRepository")
public interface PeritosRepository extends JpaRepository<Peritos, Serializable>{
    
    public List<Peritos> findByCiudadLike(String ciudad);

    // numero via 

    public List<Peritos> findByNumeroViaIsNull();
}
