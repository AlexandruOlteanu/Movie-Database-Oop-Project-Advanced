package database;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
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
    private int number;
    private double grade;
    private int season;
    private FilterDTO filters;
}
