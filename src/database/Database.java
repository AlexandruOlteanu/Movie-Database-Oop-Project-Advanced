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
