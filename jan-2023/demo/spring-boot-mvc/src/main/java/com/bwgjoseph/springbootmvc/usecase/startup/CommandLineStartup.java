package com.bwgjoseph.springbootmvc.usecase.startup;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CommandLineStartup implements CommandLineRunner {

    // useful when want to access the args
    @Override
    public void run(String... args) throws Exception {
      log.info("running CommandLineStartup commands");          
    }
    
}
