package universales.practica1.API_busqueda.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import universales.practica1.API_busqueda.model.*;
import universales.practica1.API_busqueda.model.tvmaze.people.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/rest")

public class API {
	
	private final RestTemplate restTemplate = new RestTemplate();
	private final String ITUNES_URL = "https://itunes.apple.com";
	private final String TVMAZE_URL = "https://api.tvmaze.com/search";
	
	private ArrayList<Artista> artistas = new ArrayList<Artista>();
	private String itunesArtistaEndpoint = this.ITUNES_URL + "/search?term=" ;
	private String tvmazePeopleEndpoint = this.TVMAZE_URL + "/people?q=";
	//private String ArtistName = "";
	
	@GetMapping("/find/{artistName}")
	public String getArtist(@PathVariable("artistName") String artistName) throws JsonMappingException, JsonProcessingException {
	
		System.out.println("El artista es:" + artistName);
		Cancion[] itunesArtists = this.consultarArtistaItunes(artistName);
		 
		for(Cancion cancion: itunesArtists){
			 
			Artista artista = new Artista(); 
			artista.setName(cancion.getArtistName());
			artista.setTrackName(cancion.getTrackName());
			artista.setType(cancion.getWrapperType());
			artista.setService("API_ITUNES"); 
			artista.setServiceUrl(this.itunesArtistaEndpoint); 
			 
			this.artistas.add(artista);		  
			//System.out.println(artista);
		}
		 
		People[] people = this.consultarPeopleTvmaze(artistName);
		
		Person personaTemporal = null;
		for (People p: people){
			
			personaTemporal = p.getPerson();
			
			Artista artista = new Artista();
			artista.setName(personaTemporal.getName());
			artista.setTrackName("null");
			artista.setType("people");
			artista.setService("API_TVMAZE"); 
			artista.setServiceUrl(this.tvmazePeopleEndpoint);
			
			this.artistas.add(artista);	
			//System.out.println(p);
		}
		 
		ObjectMapper objectMapper = new ObjectMapper();
		 
	    String artistaAsJason = objectMapper.writeValueAsString(this.artistas);
	    System.out.println(artistaAsJason);
	    
		return artistaAsJason;
	}
	
	private Cancion[] consultarArtistaItunes(String artistName) throws JsonMappingException, JsonProcessingException {
		
		this.itunesArtistaEndpoint = this.itunesArtistaEndpoint + artistName;
		String data = this.restTemplate.getForObject(this.itunesArtistaEndpoint, String.class);	
		
		ObjectMapper objectMapper = new ObjectMapper();
		Track mytrack = objectMapper.readValue(data, Track.class);
		 
		return mytrack.results;
	}


	private People[] consultarPeopleTvmaze(String artistName) throws JsonMappingException, JsonProcessingException {
		
		this.tvmazePeopleEndpoint = this.tvmazePeopleEndpoint + artistName;
		
		String TvMazeData = this.restTemplate.getForObject(this.tvmazePeopleEndpoint, String.class);
		
		ObjectMapper objectMapper = new ObjectMapper();
		People people[] = objectMapper.readValue(TvMazeData, People[].class);
		
		return people;
	}
	
	
}
