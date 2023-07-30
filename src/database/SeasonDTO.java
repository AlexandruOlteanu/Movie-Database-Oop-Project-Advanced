package database;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SeasonDTO {
    private Integer current_season;
    private Integer duration;
}
