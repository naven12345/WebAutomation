package example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingInfo {

    static Logger log = LogManager.getLogger();
    public static void main(String[] args) {
        System.out.println("Execution Started: ");
        log.trace("This is for trace information");
        log.info("This is for information");
        log.warn("This is for warning information");
        log.error("This is for error information");
        log.fatal("This is for fatal information");

        System.out.println("Execution done: ");
    }
}
