package action.command;

import database.*;
import org.json.simple.JSONObject;
import writer.Writer;

import java.util.ArrayList;
import java.util.List;

public class Rating {

    public static JSONObject solveAction(Database database, ActionDTO actionDTO) throws Exception {

        UserDTO userDTO = database.getDatabase().getUsers().stream()
                .filter(user -> user.getUsername().equals(actionDTO.getUser()))
                .findFirst().orElse(null);
        if (null == userDTO) {
//            ThrowException.throwException(actionDTO.getAction_id(), "User not found");
            return null;
        }

        boolean seen = userDTO.getHistory().stream()
                .anyMatch(video -> video.getName().equals(actionDTO.getTitle()));

        if (!seen) {
            return Writer.writeFile(actionDTO.getAction_id(), null, "error -> " + actionDTO.getTitle() + " was not seen");
        }

        if (null != actionDTO.getSeason()) {
            List<Integer> ratedSeasons = userDTO.getRatedShows().get(actionDTO.getTitle());
            if (null == ratedSeasons) {
                userDTO.getRatedShows().put(actionDTO.getTitle(), List.of(actionDTO.getSeason()));
                ShowDTO.rateShow(database.getDatabase().getShows(), actionDTO.getTitle(), actionDTO.getGrade(), actionDTO.getSeason());
                return Writer.writeFile(actionDTO.getAction_id(), null, "success -> " + actionDTO.getTitle() + " was rated with " + actionDTO.getGrade() + " by " + userDTO.getUsername());
            }

            boolean alreadyRated = ratedSeasons.stream()
                    .anyMatch(season -> season.equals(actionDTO.getSeason()));
            if (alreadyRated) {
                // TODO
                return null;
            }
            else {
                List<Integer> ratedShows = new ArrayList<>(userDTO.getRatedShows().get(actionDTO.getTitle()));
                ratedShows.add(actionDTO.getSeason());
                userDTO.getRated().put(actionDTO.getTitle(), ratedShows);
                ShowDTO.rateShow(database.getDatabase().getShows(), actionDTO.getTitle(), actionDTO.getGrade(), actionDTO.getSeason());
                return Writer.writeFile(actionDTO.getAction_id(), null, "success -> " + actionDTO.getTitle() + " was rated with " + actionDTO.getGrade() + " by " + userDTO.getUsername());
            }
        }

        boolean alreadyRated = userDTO.getRatedMovies().stream()
                .anyMatch(movie -> movie.equals(actionDTO.getTitle()));
        if (alreadyRated) {
            // TODO
        } else {
            MovieDTO.rateMovie(database.getDatabase().getMovies(), actionDTO.getTitle(), actionDTO.getGrade());
            return Writer.writeFile(actionDTO.getAction_id(), null, "success -> " + actionDTO.getTitle() + " was rated with " + actionDTO.getGrade() + " by " + userDTO.getUsername());
        }

        return null;
    }

}
