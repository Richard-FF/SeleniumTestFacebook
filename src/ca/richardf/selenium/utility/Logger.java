package ca.richardf.selenium.utility;

/**
 * Class to help log console output clearly
 */
public final class Logger {

    private static String infoSuffix = "- - - - - - - - - - - - - - - - - - - - - - - - - - - -";
    private static String exceptionSuffix = "! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! ! !";
    private static String warningSuffix = "# # # # # # # # # # # # # # # # # # # # # # # # # # # #";


    public static void logInfo(final String msg) {
        System.out.println("--- INFO: " + msg);
        System.out.println("  " + infoSuffix);
    }

    public static void logWarning(final String msg) {
        System.out.println("### WARNING: " + msg);
        System.out.println("  " + warningSuffix);
    }

    public static void logException(final String msg) {
        System.out.println("!!! Exception: " + msg);
        System.out.println("  " + exceptionSuffix);

    }
}
