package database;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public abstract class Video {
    private String name;
    private String year;
    private List<String> cast;
    private List<String> genres;

}
