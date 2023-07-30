package database;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Builder
@Getter
@Setter
@Jacksonized
public class AppDataDTO {
    List<ActorDTO> actors;
    List<UserDTO> users;
    List<MovieDTO> movies;
    List<ShowDTO> shows;
}
