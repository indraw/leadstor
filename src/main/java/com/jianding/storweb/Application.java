
package com.jianding.storweb;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jianding.storweb.service.ContactService;


@ComponentScan({"com.jianding", "jianding.com.VolumeOps"})
@EnableAutoConfiguration
@EnableTransactionManagement
public class Application extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
    
    public static void main(String... args) throws IOException {
        ApplicationContext appContext = SpringApplication.run(Application.class, args);
        
        ContactService contactService = appContext.getBean(ContactService.class);
        String filePath = (args.length > 0)? args[0] : "etc/contacts.txt";
        contactService.loadContacts(filePath);
    }
}