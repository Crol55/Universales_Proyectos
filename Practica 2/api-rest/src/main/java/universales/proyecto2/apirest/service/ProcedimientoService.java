package universales.proyecto2.apirest.service;

import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import universales.proyecto2.apirest.dto.FiltrarPolizaDto;
import universales.proyecto2.apirest.dto.SegurosDto;

@Service
public class ProcedimientoService {

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
		
		/*Date date = null;
		try {
			date = new SimpleDateFormat("dd-MM-yyyy").parse("06-03-2022");//2022-03-07 "06-03-2022"
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
		simpleJdbcCall.withProcedureName("filtrarpoliza").withoutProcedureColumnMetaDataAccess().declareParameters(
				new SqlParameter("dni_cl", Types.NUMERIC), 
				new SqlOutParameter("ramo", Types.VARCHAR), 
				new SqlInOutParameter("fecha", Types.DATE)
		);
		
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("dni_cl", segurosDto.getClienteDniCl())
				.addValue("fecha", segurosDto.getFechaInicio());
		
		Map<String, Object> respuesta = simpleJdbcCall.execute(sqlParameterSource);
		
		FiltrarPolizaDto filtrarPolizaDto =  new FiltrarPolizaDto(); 
		filtrarPolizaDto.setRamo( respuesta.get("ramo").toString() );
		filtrarPolizaDto.setFechaVencimiento((Date) respuesta.get("fecha"));
		
		System.out.println(respuesta.get("ramo").toString());
		
		System.out.println("Creo que debio funcionar XD");
		
		return filtrarPolizaDto;
	}
}
