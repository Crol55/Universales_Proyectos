package universales.proyecto2.apirest.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import universales.proyecto2.apirest.entity.Seguros;

@Repository("segurosRepository")
public interface SegurosRepository extends JpaRepository<Seguros, Serializable>{

    public List<Seguros> findByRamoLike(String ramo);

    public List<Seguros> findByFechaInicioBefore(Date fechaInicio);

    public List<Seguros> findByRamoLikeOrderByFechaVencimientoDesc(String ramo);

}
