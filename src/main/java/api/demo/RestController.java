import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

@CrossOrigin
@RestController
public class RestController {

    private static final String API_KEY = "321c38d6cd074dacd13470c538d5a8fe";
    
    @GetMapping("/peliculas/{query}")
    public List<Pelicula> obtenerPeliculasPorNombre(@PathVariable String query) {
        RestTemplate restTemplate = new RestTemplate();
        PeliculasResponse response = restTemplate.getForObject(
            "https://api.themoviedb.org/3/search/movie?api_key={API_KEY}&query={query}",
            PeliculasResponse.class,
            API_KEY,
            query
        );

}
