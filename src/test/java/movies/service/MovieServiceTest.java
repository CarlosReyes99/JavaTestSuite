package movies.service;

import movies.data.MovieRepository;
import movies.model.Genre;
import movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static movies.model.Genre.COMEDY;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {
    /**
     * Prueba que findMovieByGenre() retorne correctamente las películas de un género dado.
     * Prueba que return_movies_by_duration() devuelva las películas menor o igual a X duración
     * Se mockea el repositorio para devolver una lista fija de películas con diferentes géneros.
     * Luego se llama a findMovieByGenre(COMEDY) y se verifica que los IDs devueltos
     * coincidan con las películas esperadas de dicho género.
     *
     * Este test permite probar la lógica de búsqueda por género sin depender
     * de una base de datos real. También valida que no haya filtrado de más ni de menos.
     */
    MovieService movieService;
    @BeforeEach
    void setUp() {
        MovieRepository movieRepository= Mockito.mock(MovieRepository.class);
        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, Genre.ACTION, "Christopher Nolan", "Emma Thomas"),
                        new Movie(2, "Memento", 113, Genre.THRILLER, "Quentin Tarantino", "Lawrence Bender"),
                        new Movie(3, "There's Something About Marty", 119, Genre.COMEDY, "Martin Scorsese", "Jane Rosenthal"),
                        new Movie(4, "Super 8", 112, Genre.THRILLER, "Steven Spielberg", "J.J. Abrams"),
                        new Movie(5, "Scream", 112, Genre.HORROR, "Wes Craven", "Cathy Konrad"),
                        new Movie(6, "Home Alone", 112, Genre.COMEDY, "Chris Columbus", "John Hughes"),
                        new Movie(7, "Home Test", 112, Genre.COMEDY, "Chris Columbus", "John Hughes"),
                        new Movie(8, "Matrix", 136, Genre.ACTION, "Lana Wachowski", "Lilly Wachowski"),
                        new Movie(9, "Dark Knight", 152, Genre.ACTION, "Christopher Nolan", "Emma Thomas")
                )
        );
        movieService = new MovieService(movieRepository);
    }



    @Test
    void return_movies_by_genre() {

        Collection<Movie> movies= movieService.findMovieByGenre(COMEDY);
        List<Integer> movieIds= getIntegers(movies);
        assertThat(movieIds, CoreMatchers.is(Arrays.asList(3,6, 7)));

    }
    @Test
    void return_movies_by_duration() {

        Collection<Movie> movies= movieService.findMovieByDuration(150);
        List<Integer> movieIds = getIntegers(movies);
        assertThat(movieIds, CoreMatchers.is(Arrays.asList(2, 3, 4, 5, 6, 7, 8)));

    }

    @Test
    void returnMoviesByName() {
        Collection<Movie> movies= movieService.findMovieByName("Home");
        List<Integer> movieIds= getIntegers(movies);
        assertThat(movieIds, CoreMatchers.is(Arrays.asList(6, 7)));
    }


    @Test
    void returnMoviesByDirector() {
        Collection<Movie> movies= movieService.findMovieByDirector("Christopher");
        List<Integer> movieIds= getIntegers(movies);
        assertThat(movieIds, CoreMatchers.is(Arrays.asList(1, 9)));
    }




    private static List<Integer> getIntegers(Collection<Movie> movies) {
        return movies.stream().map(movie -> movie.getId()).collect(Collectors.toList());
    }
}