package jmstp;

/**
 * Created by jamesRMBP on 17/11/14.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.FileSystemUtils;

import java.io.File;


public class Receiver {
    @Autowired
    ConfigurableApplicationContext context;

    /**
     * When you receive a message, print it out, then shut down the application.
     * Finally, clean up any ActiveMQ server stuff.
     */

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        context.close();
        FileSystemUtils.deleteRecursively(new File("activemq-data"));
    }
}
