package universales.proyecto2.apirest.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import universales.proyecto2.apirest.entity.Cliente;

@Repository("clienteRepository")
public interface ClienteRepository extends JpaRepository<Cliente,Serializable>{
    
    public List<Cliente> findByCodPostal(String codPostal);

    public List<Cliente> findByApellido1OrApellido2(String apellido1, String apellido2);
}
