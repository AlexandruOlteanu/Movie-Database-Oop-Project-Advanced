package database;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Getter
@Setter
public class ShowDTO extends Video{
    private Integer number_of_seasons;
    List<SeasonDTO> seasons;
}
