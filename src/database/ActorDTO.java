package database;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class ActorDTO {
    private String name;
    private String career_description;
    private List<String> filmography;
    private List<AwardDTO> awards;
}
