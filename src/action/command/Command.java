package action.command;

import action.Action;
import database.ActionDTO;
import database.Database;
import org.json.simple.JSONObject;

import static constants.Constants.*;

public class Command implements Action {

    @Override
    public JSONObject solveAction(Database database, ActionDTO action) throws Exception {
        return switch (action.getType()) {
            case FAVOURITE -> Favourite.solveAction(database, action);
            case VIEW -> View.solveAction(database, action);
            case RATING -> Rating.solveAction(database, action);
            default -> throw new IllegalStateException("Unexpected value: " + action.getType());
        };
    }
}
