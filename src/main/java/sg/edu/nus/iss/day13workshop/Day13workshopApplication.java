package sg.edu.nus.iss.day13workshop;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sg.edu.nus.iss.day13workshop.services.DatabaseService;

//run with >mvn spring-boot:run -Dspring-boot.run.arguments="--dataDir=C:\Users\coyot\vttp2022\SSF\day13"

@SpringBootApplication
public class Day13workshopApplication implements ApplicationRunner {

	// after defining the service, wire it to be used by the application. use
	// DatabaseSerivce
	@Autowired // dont need to instantiate databaseservice
	DatabaseService dbSv;

	public static void main(String[] args) {
		SpringApplication.run(Day13workshopApplication.class, args);
	}

	// run is a function in ApplicationRunner. It handles the arguement
	// refer to day 11 to try not using application runner
	@Override
	public void run(ApplicationArguments args) {
		if (args.containsOption("dataDir")) {
			final String dataDir = args.getOptionValues("dataDir").get(0);
			// creating the File in location now
			dbSv.setDataDir(new File(dataDir));

			if (!dbSv.isDataDirValid()) {
				System.err.printf("%s ddoes not exist is not a directory or not writable" , dataDir);
				System.exit(-1);
			}
			System.out.printf("Using %s as a data directory\n", dataDir);
		} else {
			dbSv.setDataDir(new File("C:\\Users\\coyot\\vttp2022\\SSF\\day13\\data"));

		}
	}

	

}
