package action.query;

import action.Action;
import database.ActionDTO;
import database.Database;
import org.json.simple.JSONObject;

import java.io.IOException;

public class Query implements Action {
    @Override
    public JSONObject solveAction(Database database, ActionDTO action) throws IOException {
        return null;
    }
}
