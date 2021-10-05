package com.bwgjoseph.techsharing;

import com.bwgjoseph.techsharing.config.ApplicationConfig;
import com.bwgjoseph.techsharing.profile.ProfileService;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class TechsharingApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		var ps = appContext.getBean("profileService", ProfileService.class); // appContext.getBean(ProfileService.class);
		System.out.println(ps.getAllProfilePost(10));
		// Calling close will then trigger predestroy, pdestroy, and destroy method
		appContext.close();

		// SpringApplication.run(TechsharingApplication.class, args);
	}
}
