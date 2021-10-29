package org.somename;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.somename.data.CourseRepository;
import org.somename.data.PersonRepository;
import org.somename.mock.data.MockDataCreator_h2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RegrnApplication implements ApplicationRunner, CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(RegrnApplication.class);
	
	@Autowired
	private PersonRepository pRepo;
	@Autowired
	private CourseRepository cRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(RegrnApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		MockDataCreator_h2.getInstance().initialize(pRepo, cRepo);
		//MockDataCreator_h2.getInstance().initialize(pRepo);
		//MockDataCreator_h2.getInstance().initialize(cRepo);
	}

	@Override
	public void run(String... args) throws Exception {
		MockDataCreator_h2.getInstance().initialize(pRepo, cRepo);
		//MockDataCreator_h2.getInstance().initialize(cRepo);
	}

}
