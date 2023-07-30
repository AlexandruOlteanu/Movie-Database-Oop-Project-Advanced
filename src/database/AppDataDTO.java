package database;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class AppDataDTO {
    List<ActorDTO> actors;
    List<UserDTO> users;
    List<MovieDTO> movies;
    List<ShowDTO> shows;

    private AppDataDTO() {

    }

    public static AppDataDTO instance = null;

    public static AppDataDTO getInstance() {
        if (null == instance) {
            instance = new AppDataDTO();
        }
        return instance;
    }
}
