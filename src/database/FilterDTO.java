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
public class FilterDTO {
    private String year;
    private String genre;
    private List<String> words;
    private List<String> awards;
}
