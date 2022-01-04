package universales.proyecto2.apirest.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import universales.proyecto2.apirest.entity.Seguros;
import universales.proyecto2.apirest.repository.SegurosRepository;

@RestController
@RequestMapping("/seguros")
@CrossOrigin
public class SegurosService {
    
    @Autowired
    SegurosRepository segurosRepository;


    @GetMapping(path = "/buscar")
    public List<Seguros> buscaString() {
        
        return this.segurosRepository.findAll();
    }

    @PostMapping(path = {"/guardar", "/actualizar"})
    public Seguros buscar(@RequestBody Seguros segurosData) {
        
        segurosRepository.save(segurosData);

        return segurosData;
    }

    @PostMapping( path = "/eliminar" )
    public String eliminar(@RequestBody Seguros seguroData){

        Optional <Seguros> seguroExistente = segurosRepository.findById(seguroData.getNumeroPoliza());
        if (seguroExistente.isPresent()){
            segurosRepository.delete(seguroExistente.get());
        }
        return "Successful";
    }

    @GetMapping( path = "/buscar/ramo/{ramo}" )
    public List<Seguros> buscarPorRamoLike(@PathVariable String ramo){
        
        return segurosRepository.findByRamoLike(ramo);
    }

    @GetMapping(path = "/buscar/antesFecha/{fechaInicio}") 
    public List<Seguros> buscarPorFechaInicioAnterior(@PathVariable String fechaInicio) throws ParseException{
    
        //String Datestr="23/05/2023"; 
        Date date=new SimpleDateFormat("dd-MM-yyyy").parse(fechaInicio); 
        return segurosRepository.findByFechaInicioBefore(date);
    }

    @GetMapping(path = "/buscar/ordenarFechaVencimiento/{ramo}") 
    public List<Seguros> buscarPorVigencia(@PathVariable String ramo) throws ParseException{
    
        //String Datestr="23/05/2023"; 
        //Date date=new SimpleDateFormat("dd-MM-yyyy").parse(ramo); 
        return segurosRepository.findByRamoLikeOrderByFechaVencimientoDesc(ramo);
    }

    
}
