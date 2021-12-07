package com.example.holaMundo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@SpringBootApplication
@RestController
@RequestMapping("/miServicio")

public class HolaMundoApplication {
	
	@GetMapping(path="/holamundo/{yourName}")
	public String helloResponse(@PathVariable("yourName") String yourName) {
		return "Hola "+yourName;
	}

	public static void main(String[] args) {
		SpringApplication.run(HolaMundoApplication.class, args);
	}

}
