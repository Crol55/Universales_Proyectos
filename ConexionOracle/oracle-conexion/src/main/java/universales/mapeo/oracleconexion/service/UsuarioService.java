package universales.mapeo.oracleconexion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import universales.mapeo.oracleconexion.repository.UsuarioRepository;

import universales.mapeo.oracleconexion.entity.*;

@RestController 
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioService {

	@Autowired 
	UsuarioRepository usuarioRepository;
	
	@GetMapping(path = "/buscar")
	public List<Usuario> buscar(){
		System.out.println("pues si estoy ingresando?");
		return usuarioRepository.findAll();
	}
	
	@PostMapping(path="guardar")
	public Usuario guardar(@RequestBody Usuario usuario) {
		
		
		return usuarioRepository.save(usuario);
	} 
}
