package MovieApi;

public class Utilities {
    public static void reportException(Exception e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        System.exit(0);
    }
}
