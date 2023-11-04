package movies.service;

import movies.data.MovieRepository;
import movies.model.Genre;
import movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Servicio para consultar y obtener películas según diferentes criterios.
 * Hace uso de un MovieRepository para obtener los datos de las películas.
 */
public class MovieService {
    /**
     * Repositorio de donde se obtienen las películas.
     * Se inyecta a través del constructor para desacoplar esta
     * clase de los detalles de implementación del repositorio.
     */
    private MovieRepository movieRepository;
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    /**
     * Obtiene las películas de un género determinado.
     *
     * @param genre el género por el cual filtrar.
     * @return lista de películas que coinciden con el género.
     */
    public Collection<Movie> findMovieByGenre(Genre genre) {
        return movieRepository.findAll().stream().filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());
    }


    /**
     * Obtiene las películas con una duración menor o igual al parámetro.
     *
     * @param minutes duración máxima en minutos.
     * @return lista de películas con duración menor al valor dado.
     */
    public Collection<Movie> findMovieByDuration(int minutes) {
        return movieRepository.findAll().stream().filter(movie -> movie.getMinutes() <= minutes).collect(Collectors.toList());
    }

    /**
     * Obtiene las películas con un nombre igual o similar
     *
     * @param movieName nombre de películas a buscar.
     * @return lista de películas que contengan ese string
     */
    public Collection<Movie> findMovieByName(String movieName) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getName().toLowerCase().contains(movieName.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Collection<Movie> findMovieByDirector(String nameDirector) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getDirector1().toLowerCase().contains(nameDirector.toLowerCase()))
                .collect(Collectors.toList());
    }
}
