package action;

import database.ActionDTO;
import database.Database;
import org.json.simple.JSONObject;

import java.io.IOException;

public interface Action {

    JSONObject solveAction(Database database, ActionDTO action) throws Exception;
}
