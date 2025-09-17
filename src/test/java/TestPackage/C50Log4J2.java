package TestPackage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

public class C50Log4J2 {
    /*
    - ALL: Enables logging and logs everything.
    - DEBUG: Prints debugging information and helps during development phase.
    - INFO: Prints informational messages that highlight the progress of the application.
    - WARN: Prints information about erroneous and unexpected system behavior.
    - ERROR: Prints error messages that may allow the system to continue.
    - FATAL: Prints critical system information that causes the application to crash.
    - OFF: No logging is done, meaning nothing is logged.
    */

    @Test
    public void log4jTest() {
        Logger logger = LogManager.getLogger(C50Log4J2.class);

        logger.trace("TRACE: Very detailed debugging message (usually not used).");


        logger.debug("DEBUG: Debugging information like variable values, method calls.");

        logger.info("INFO: General informational message about the application.");

        logger.warn("WARN: A potential problem has been detected!");

        logger.error("ERROR: An error occurred, but the application continues running.");

        logger.fatal("FATAL: Critical error, application may crash!");

        // By default in Log4J, only error and fatal level logs are written to console
        // If we want to change the log levels, we need to configure Log4J --> create log4j2.xml file under src/test/resources/
    }
}