package com.spal.self.fbservice;

import com.spal.self.fbservice.services.FbLoginService;
import com.spal.self.fbservice.services.LinkedInServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class FbServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FbServiceApplication.class, args);
	}
	@Autowired
	private FbLoginService fbLoginService;

	@Autowired
	private LinkedInServices linkedInServices;

	@Override
	public void run(String... args) throws Exception {
		//fbLoginService.initialiseClient();
		//fbLoginService.publishContentNow("Test RestFb", new ArrayList<>(), new ArrayList<>());
		linkedInServices.createPost();
	}
}
