package api.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;;

@SpringBootApplication
public class FilmSpringAppApplication {
	@Autowired
	private static RestController controller;

	public static void main(String[] args) {
		SpringApplication.run(FilmSpringAppApplication.class, args);
		if (controller != null) {
			controller.obtenerPeliculasPorNombre("Avatar");
		}
	}

}
