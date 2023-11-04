package movies.data;

import movies.model.Genre;
import movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.RowMapper;


import java.util.Collection;

public class MovieRepositoryJdbc implements MovieRepository {
    public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private JdbcTemplate jdbcTemplate;
    @Override
    public Movie findById(long id) {

        Object[] args= {id};
        return jdbcTemplate.queryForObject("select * from movies where id= ?", args, movieMapper);
    }

    @Override
    public Collection<Movie> findAll() {

        return jdbcTemplate.query("select * from movies", movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {
        jdbcTemplate.update("INSERT INTO movies (name, minutes, genre, director1, director2) VALUES (?, ?, ?, ?, ?)", movie.getName(), movie.getMinutes(), movie.getGenre().toString(), movie.getDirector1(), movie.getDirector2());

    }

    public static  RowMapper<Movie> movieMapper = (resultSet, i) -> {
        return new Movie(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getInt("minutes"),
                Genre.valueOf(resultSet.getString("genre")),
                resultSet.getString("director1"),
                resultSet.getString("director2")

        );
    };

}
