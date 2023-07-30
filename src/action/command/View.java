package action.command;

import database.ActionDTO;
import database.Database;
import database.HistoryDTO;
import database.UserDTO;
import org.json.simple.JSONObject;
import writer.Writer;

public class View {

    public static JSONObject solveAction(Database database, ActionDTO actionDTO) throws Exception {

        UserDTO userDTO = database.getDatabase().getUsers().stream()
                .filter(user -> user.getUsername().equals(actionDTO.getUser()))
                .findFirst().orElse(null);
        if (null == userDTO) {
//            ThrowException.throwException(actionDTO.getAction_id(), "User not found");
            return null;
        }

        HistoryDTO historyDTO = userDTO.getHistory().stream()
                .filter(video -> video.getName().equals(actionDTO.getTitle()))
                .peek(video -> video.setNo_views(video.getNo_views() + 1))
                .findFirst().orElse(null);
        if (null == historyDTO) {
            historyDTO = HistoryDTO.builder()
                    .name(actionDTO.getTitle())
                    .no_views(1)
                    .build();
            userDTO.getHistory().add(historyDTO);
        }

        return Writer.writeFile(actionDTO.getAction_id(), null, "success -> " + actionDTO.getTitle() + " was viewed with total views of " + historyDTO.getNo_views());
    }
}
