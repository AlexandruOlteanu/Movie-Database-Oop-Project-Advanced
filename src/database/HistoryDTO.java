package database;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class HistoryDTO {
    private String name;
    private Integer no_views;
}
