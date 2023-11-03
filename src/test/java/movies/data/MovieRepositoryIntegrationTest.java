package movies.data;
import movies.model.Genre;
import movies.model.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;



class MovieRepositoryIntegrationTest {

    @Test
    void load_all_movies() throws SQLException {
        // Configurar una base de datos H2 en memoria con datos de prueba
        DataSource dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");

        // Ejecutar un script SQL para cargar datos de prueba en la base de datos
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));

        // Configurar un objeto JdbcTemplate para interactuar con la base de datos
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        // Crear un repositorio de películas utilizando JdbcTemplate
        MovieRepositoryJdbc movieRepository = new MovieRepositoryJdbc(jdbcTemplate);

        // Obtener una colección de películas de la base de datos utilizando el repositorio
        Collection<Movie> movies = movieRepository.findAll();

        // Crear una lista de películas esperada
        Collection<Movie> expectedMovies = Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION),
                new Movie(2, "Memento", 113, Genre.THRILLER),
                new Movie(3, "Matrix", 136, Genre.ACTION)
        );

        // Verificar si la colección de películas obtenida es igual a la lista esperada
        Assertions.assertEquals(expectedMovies, movies);

    }
}