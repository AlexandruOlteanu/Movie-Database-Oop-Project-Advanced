package exception;

public class ThrowException {

    public static void throwException(Integer actionId, String message) throws Exception {
        throw new Exception("Error in action " + actionId +": " + message);
    }

}
