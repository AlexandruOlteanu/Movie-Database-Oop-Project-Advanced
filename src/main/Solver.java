package main;

import action.Action;
import action.command.Command;
import action.query.Query;
import action.recommendation.Recommendation;
import database.ActionDTO;
import database.Database;
import org.json.simple.JSONArray;

import java.io.IOException;

import static constants.Constants.*;

public class Solver {

    private final Database database;

    public Solver(Database database) {
        this.database = database;
    }

    public JSONArray solveActions() {
        JSONArray jsonArray = new JSONArray();

        database.getActions().forEach(actionDTO -> {
            Action action;
            switch (actionDTO.getAction_type()) {
                case COMMAND :
                    action = new Command();
                    break;
                case QUERY:
                    action = new Query();
                    break;
                case RECOMMENDATION:
                    action = new Recommendation();
                    break;
                default:
                    action = new Command();
                    break;
            }
            try {
                jsonArray.add(action.solveAction(database, actionDTO));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        return jsonArray;
    }

}
