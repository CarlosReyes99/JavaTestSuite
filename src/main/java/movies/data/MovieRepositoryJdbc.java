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
        return null;
    }

    @Override
    public Collection<Movie> findAll() {

        return jdbcTemplate.query("select * from movies", movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {

    }

    public static  RowMapper<Movie> movieMapper = (resultSet, i) -> {
        return new Movie(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getInt("minutes"),
                Genre.valueOf(resultSet.getString("genre")));
    };
}
