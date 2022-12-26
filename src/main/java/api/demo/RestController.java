package api.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.client.RestTemplate;

@CrossOrigin
@Cacheable("peliculas")
public class RestController {

    public static final String API_KEY = "321c38d6cd074dacd13470c538d5a8fe";
    
    @GetMapping("/peliculas/{query}")
    public List<Pelicula> obtenerPeliculasPorNombre(@PathVariable String query) {
        RestTemplate restTemplate = new RestTemplate();
        PeliculasResponse response = restTemplate.getForObject(
            "https://api.themoviedb.org/3/search/movie?api_key={API_KEY}&query={query}",
            PeliculasResponse.class,
            API_KEY,
            query
        );
        return (List<Pelicula>) response;
    }
}
