package universales.proyecto2.apirest.service;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import universales.library.dto.practica2.FiltrarPolizaDto;
import universales.library.dto.practica2.SegurosDto;

@Service
public class ProcedimientoService {

	private static final String FECHA = "fecha"; 
	 
	@Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public int insertarPoliza(SegurosDto segurosDto){
		
        String query = "begin "
        		+ "insertpoliza(:numeroPoliza, :ramo, :fechaInicio, :fechaVencimiento, :condicionesParticulares, :observaciones, :clienteDniCl); "
        		+ "end;";
        
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
        .addValue("numeroPoliza", segurosDto.getNumeroPoliza()).addValue("ramo", segurosDto.getRamo())
        .addValue("fechaInicio", segurosDto.getFechaInicio()).addValue("fechaVencimiento", segurosDto.getFechaVencimiento())
        .addValue("condicionesParticulares", segurosDto.getCondicionesParticulares())
        .addValue("observaciones", segurosDto.getObservaciones()).addValue("clienteDniCl", segurosDto.getClienteDniCl());

        return namedParameterJdbcTemplate.update(query, sqlParameterSource);
    }
	
	
	public FiltrarPolizaDto filtrarPoliza (SegurosDto segurosDto) {
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
		simpleJdbcCall.withProcedureName("filtrarpoliza").withoutProcedureColumnMetaDataAccess().declareParameters(
				new SqlParameter("dni_cl", Types.NUMERIC), 
				new SqlOutParameter("ramo", Types.VARCHAR), 
				new SqlInOutParameter(FECHA, Types.DATE)
		);
		
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("dni_cl", segurosDto.getClienteDniCl())
				.addValue(FECHA, segurosDto.getFechaInicio());
		
		Map<String, Object> respuesta = simpleJdbcCall.execute(sqlParameterSource);
		
		FiltrarPolizaDto filtrarPolizaDto =  new FiltrarPolizaDto(); 
		filtrarPolizaDto.setRamo( respuesta.get("ramo").toString() );
		filtrarPolizaDto.setFechaVencimiento((Date) respuesta.get(FECHA));
		
		return filtrarPolizaDto;
	}
	
	public int insertarPolizaFunction(SegurosDto segurosDto) {
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
		simpleJdbcCall.withSchemaName("Practica2")
			.withCatalogName("polizaPackage")
			.withFunctionName("insert_poliza");
		
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
				.addValue("NUMPERO_POLIZA", segurosDto.getNumeroPoliza())
				.addValue("RAMO", segurosDto.getRamo())
		        .addValue("FECHA_INICIO", segurosDto.getFechaInicio())
		        .addValue("FECHA_VENCIMIENTO", segurosDto.getFechaVencimiento())
		        .addValue("CONDICIONES_PARTICULARES", segurosDto.getCondicionesParticulares())
		        .addValue("OBSERVACIONES", segurosDto.getObservaciones())
		        .addValue("cliente_dni_cl", segurosDto.getClienteDniCl());
		
		return simpleJdbcCall.executeFunction(BigDecimal.class, sqlParameterSource).intValue();
		
	}
}
