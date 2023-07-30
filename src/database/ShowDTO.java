package database;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Getter
@Setter
public class ShowDTO extends Video{
    private Integer number_of_seasons;
    List<SeasonDTO> seasons;
}
