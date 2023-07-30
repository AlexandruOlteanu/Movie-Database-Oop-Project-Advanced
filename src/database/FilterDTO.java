package database;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class FilterDTO {
    private String year;
    private String genre;
    private List<String> words;
    private List<String> awards;
}
