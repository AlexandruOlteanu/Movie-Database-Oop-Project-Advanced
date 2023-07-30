package action.command;

import database.ActionDTO;
import database.Database;
import database.UserDTO;
import exception.ThrowException;
import org.json.simple.JSONObject;
import writer.Writer;

import java.io.IOException;

public class Favourite {

    public static JSONObject solveAction(Database database, ActionDTO actionDTO) throws Exception {

        UserDTO userDTO = database.getDatabase().getUsers().stream()
                .filter(user -> user.getUsername().equals(actionDTO.getUser()))
                .findFirst().orElse(null);
        if (null == userDTO) {
//            ThrowException.throwException(actionDTO.getAction_id(), "User not found");
              return null;
        }

        boolean seen = userDTO.getHistory().stream()
                .anyMatch(video -> video.getName().equals(actionDTO.getTitle()) && video.getNo_views() != 0);
        if (!seen) {
            return Writer.writeFile(actionDTO.getAction_id(), null, "error -> " + actionDTO.getTitle() + " is not seen");
        }
        boolean alreadyInFavourite = userDTO.getFavourite().stream()
                .anyMatch(video -> video.equals(actionDTO.getTitle()));

        if (alreadyInFavourite) {
            return Writer.writeFile(actionDTO.getAction_id(), null, "error -> " + actionDTO.getTitle() + " is already in favourite list");
        }

        JSONObject jsonObject = Writer.writeFile(actionDTO.getAction_id(), null, "success");

        return jsonObject;
    }

}
