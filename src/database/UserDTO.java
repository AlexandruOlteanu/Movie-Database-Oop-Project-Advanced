package database;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;

import java.util.*;

@Getter
@Setter
public class UserDTO {
    private String username;
    private String subscription;
    private List<HistoryDTO> history;
    private List<String> favourite;

    // Needed for calculations
    public Map<String, List<Integer>> ratedShows = new HashMap<>();
    public Map<String, List<Integer>> getRated() {
        return ratedShows;
    }
    public Set<String> ratedMovies = new HashSet<>();
}
