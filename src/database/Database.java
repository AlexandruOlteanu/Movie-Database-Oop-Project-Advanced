package database;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class Database {

    private AppDataDTO database;

    private List<ActionDTO> actions;

    private static Database instance = null;

    public static void setInstance(Database database) {
        instance = database;
    }

    public static Database getInstance() {
        return instance;
    }
}
