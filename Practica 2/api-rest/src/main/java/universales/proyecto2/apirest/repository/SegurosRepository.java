package universales.proyecto2.apirest.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import universales.proyecto2.apirest.entity.Seguros;

@Repository("segurosRepository")
public interface SegurosRepository extends JpaRepository<Seguros, Serializable>{
    
}
