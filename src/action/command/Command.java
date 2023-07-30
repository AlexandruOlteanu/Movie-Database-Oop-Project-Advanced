package action.command;

import action.Action;
import database.ActionDTO;
import database.Database;
import org.json.simple.JSONObject;

import java.io.IOException;

import static constants.Constants.FAVOURITE;

public class Command implements Action {

    @Override
    public JSONObject solveAction(Database database, ActionDTO action) throws Exception {
        switch (action.getType()) {
            case FAVOURITE:
                return Favourite.solveAction(database, action);
            default:
                return new JSONObject();
        }
    }
}
