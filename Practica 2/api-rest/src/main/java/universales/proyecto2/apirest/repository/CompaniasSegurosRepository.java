package universales.proyecto2.apirest.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import universales.proyecto2.apirest.entity.CompaniasSeguros;

@Repository("companiasSegurosRepository")
public interface CompaniasSegurosRepository extends JpaRepository<CompaniasSeguros, Serializable>{
    
}
