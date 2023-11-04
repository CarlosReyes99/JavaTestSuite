package movies.model;

import java.util.Objects;

public class Movie {

    public Movie(String name, int minutes, Genre genre, String director1, String director2){
        this(null, name, minutes, genre, director1, director2);
    }
    public Movie(Integer id, String name, int minutes, Genre genre, String director1, String director2) {
        this.id = id;
        this.name = name;
        this.minutes = minutes;
        this.genre = genre;
        this.director1 = director1;
        this.director2 = director2;
    }
    private Integer id;
    private String name;
    private int minutes;
    private Genre genre;
    private String director1, director2;
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMinutes() {
        return minutes;
    }

    public Genre getGenre() {
        return genre;
    }
    public String getDirector1() {
        return director1;
    }

    public String getDirector2() {
        return director2;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return minutes == movie.minutes && Objects.equals(id, movie.id) && Objects.equals(name, movie.name) && genre == movie.genre && Objects.equals(director1, movie.director1) && Objects.equals(director2, movie.director2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, minutes, genre, director1, director2);
    }
}
