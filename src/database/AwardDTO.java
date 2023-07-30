package database;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AwardDTO {
    private String award_type;
    private Integer number_of_awards;
}
