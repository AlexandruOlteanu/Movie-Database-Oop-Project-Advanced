package database;

import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Getter
@Setter
public class MovieDTO extends Video{

    private Integer duration;
    private List<String> actors;
}
