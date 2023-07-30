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
public class UserDTO {
    private String username;
    private String subscription;
    private List<HistoryDTO> history;
    private List<String> favourite;
}
