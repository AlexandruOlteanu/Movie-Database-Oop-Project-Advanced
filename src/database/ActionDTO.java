package database;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Builder
@Getter
@Setter
@Jacksonized
public class ActionDTO {
    private Integer action_id;
    private String action_type;
    private String type;
    private String user;
    private String username;
    private String title;
    private String object_type;
    private String sort_type;
    private String criteria;
    private String genre;
    private Integer number;
    private Double grade;
    private Integer season;
    private FilterDTO filters;
}
