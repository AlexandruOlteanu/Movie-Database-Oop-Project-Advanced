package database;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class UserDTO {
    private String username;
    private String subscription;
    private List<HistoryDTO> history;
    private List<String> favourite;
}
