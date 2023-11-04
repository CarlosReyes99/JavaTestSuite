package movies.data;
import movies.model.Genre;
import movies.model.Movie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;


class MovieRepositoryIntegrationTest {

    private MovieRepositoryJdbc movieRepository;
    DataSource dataSource;
    JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setUp() throws SQLException {
        // Configurar una base de datos H2 en memoria con datos de prueba
        dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");

        // Ejecutar un script SQL para cargar datos de prueba en la base de datos
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));

        // Configurar un objeto JdbcTemplate para interactuar con la base de datos
         jdbcTemplate = new JdbcTemplate(dataSource);

        // Crear un repositorio de películas utilizando JdbcTemplate
        movieRepository = new MovieRepositoryJdbc(jdbcTemplate);

    }


    @Test
    void load_all_movies() throws SQLException {

        // Obtener una colección de películas de la base de datos utilizando el repositorio
        Collection<Movie> movies = movieRepository.findAll();

        // Crear una lista de películas esperada
        Collection<Movie> expectedMovies = Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION, "Christopher Nolan", "Emma Thomas" ),
                new Movie(2, "Memento", 113, Genre.THRILLER, "Quentin Tarantino", "Lawrence Bender"),
                new Movie(3, "Matrix", 136, Genre.ACTION, "Lana Wachowski", "Lilly Wachowski")
        );

        // Verificar si la colección de películas obtenida es igual a la lista esperada
        Assertions.assertEquals(expectedMovies, movies);

    }

    //Test de buscar películas mediante id
    @Test
    void load_movie_by_id() {
        //Se instancia una movie con id
        Movie movieFind = movieRepository.findById(2);

        //Se verifica que movieFind sea igual a la movie que se espera
        Assertions.assertEquals(new Movie(2, "Memento", 113,Genre.THRILLER, "Quentin Tarantino", "Lawrence Bender" ), movieFind);


    }

    //Test insercion de datos a DB
    @Test
    void insert_movies_into_db() {
        //Se crea nueva movie sin id, porque id es autoincrementable
        Movie movie = new Movie(9, "V de Venganza", 132, Genre.DRAMA, "Nora Director", "Daniel Director");


        //Se pasa movie a saveOrUpdate para la insercion
        movieRepository.saveOrUpdate(movie);

        //Se extrae movie de la db para saber si se inserta
        Movie movieFromDb = movieRepository.findById(4);

        //Se hace la comprobación de que movie exista en DB
        Assertions.assertEquals(movieFromDb, new Movie(4, "V de Venganza", 132, Genre.DRAMA, "Nora Director", "Daniel Director"));
    }

    @AfterEach
    void tearDown() {
        jdbcTemplate.execute("DROP ALL OBJECTS DELETE FILES");
    }
}