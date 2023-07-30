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
public class ActorDTO {
    private String name;
    private String career_description;
    private List<String> filmography;
    private List<AwardDTO> awards;
}
