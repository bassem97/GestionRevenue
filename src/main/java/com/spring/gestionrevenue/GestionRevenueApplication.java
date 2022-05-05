package com.spring.gestionrevenue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;

@SpringBootApplication
@EnableSwagger2
public class GestionRevenueApplication {

	@Autowired
	Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(GestionRevenueApplication.class, args);
	}


	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() throws UnknownHostException {

		// Port
		String port = environment.getProperty("server.port");

		browse("http://localhost:"+port+"/swagger-ui/index.html");
	}

	public static void browse(String url) {
		if(Desktop.isDesktopSupported()){
			Desktop desktop = Desktop.getDesktop();
			try {
				desktop.browse(new URI(url));
			} catch (IOException | URISyntaxException e) {
				e.printStackTrace();
			}
		}else{
			Runtime runtime = Runtime.getRuntime();
			try {
				runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
