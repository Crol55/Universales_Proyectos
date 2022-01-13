package universales.proyecto2.apirest.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import universales.proyecto2.apirest.entity.Cliente;

@Service
public class CatalogService {
    
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Map<String, Object>> buscarClientes(){

        String query = "Select * from cliente";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource();
        return namedParameterJdbcTemplate.queryForList(query, sqlParameterSource);
    }

    public void insertCliente(Cliente cliente){

        String query = "insert into cliente values (:DNI_CL, :NOMBRE_CL, :APELLIDO_1, :APELLIDO_2, :CLASE_VIA, :NOMBRE_VIA, :NUMERO_VIA, :COD_POSTAL, :CIUDAD, :TELEFONO, :OBSERVACIONES)";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
        .addValue("DNI_CL", cliente.getDniCl()).addValue("NOMBRE_CL",cliente.getNombreCl())
        .addValue("APELLIDO_1", cliente.getApellido1()).addValue("APELLIDO_2", cliente.getApellido2()).addValue("CLASE_VIA", cliente.getClaseVia())
        .addValue("NOMBRE_VIA", cliente.getNombreVia())
        .addValue("NUMERO_VIA", cliente.getNumeroVia()).addValue("COD_POSTAL", cliente.getCodPostal()).addValue("CIUDAD", cliente.getCiudad())
        .addValue("TELEFONO", cliente.getTelefono()).addValue("OBSERVACIONES", cliente.getObservaciones());
        namedParameterJdbcTemplate.update(query, sqlParameterSource);

    }

    public int updateCliente(String nombreVia, String observaciones, Integer dniCl){

        String updateQuery = "update cliente set NOMBRE_VIA = :nombreVia, OBSERVACIONES = :observaciones where DNI_CL = :dniCl";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("nombreVia", nombreVia)
        .addValue("observaciones", observaciones).addValue("dniCl", dniCl);
        namedParameterJdbcTemplate.update(updateQuery, sqlParameterSource);

        return 0;
    }

    public void deleteCliente (Integer dniCl){

        String deleteQuery = "delete from cliente where DNI_CL = :dniCl";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("dniCl", dniCl);
        namedParameterJdbcTemplate.update(deleteQuery, sqlParameterSource);
    }
}
