package com.ilyagubarev.concepts.jwt.simple.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Web application main class.
 */
@SpringBootApplication
public class Application {

    /**
     * Starts the application with specified parameters.
     *
     * @param arguments command line parameters passed on application start up.
     */
    public static void main(String... arguments) {
        SpringApplication.run(Application.class, arguments);
    }
}
