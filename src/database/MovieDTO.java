package database;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Getter
@Setter
public class MovieDTO extends Video{

    private Integer duration;
    private List<String> actors;

    private List<Double> ratings = new ArrayList<>();

    public static void rateMovie(List<MovieDTO> movies, String name, Double grade) {
        MovieDTO toRateMovie = movies.stream()
                .filter(movie -> movie.getName().equals(name))
                .findFirst().orElse(null);
        assert toRateMovie != null;
        toRateMovie.getRatings().add(grade);
    }
}
