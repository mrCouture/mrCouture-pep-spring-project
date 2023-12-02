package com.example;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LogFile;
import org.springframework.boot.logging.LoggingInitializationContext;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggingConfig {
	
	// @Autowired Environment env;

	// LoggingConfig(){
	// 	LoggingSystem loggingSystem = LoggingSystem.get(getClass().getClassLoader());

    //     // Set the log pattern
    //     setLogPattern(loggingSystem, "%d{HH:mm:ss.SSS} %-5level %logger{36} - %msg%n");
	// }

	// private void setLogPattern(LoggingSystem loggingSystem, String pattern) {
    //     LoggingInitializationContext initializationContext = new LoggingInitializationContext(env);
    //     //initializationContext.setLogFile(LogFile.get(ClassLoader.getSystemResource("logback.xml").getFile()));
    //     //initializationContext.setRootConfigLocation

    //     loggingSystem.initialize(initializationContext,null,null);
    //     //loggingSystem.setPatternConverter(pattern);
    // }
}
