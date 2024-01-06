package ideeorav.i3Digit_OS.operatingSystem;

import ideeorav.i3Digit_OS.operatingSystem.enumeration.Status;
import ideeorav.i3Digit_OS.operatingSystem.model.Filament;
import ideeorav.i3Digit_OS.operatingSystem.repository.FilamentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OperatingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OperatingSystemApplication.class, args);
	}

	@Bean
	CommandLineRunner run(FilamentRepository filamentRepository){
		return args -> {
			filamentRepository.save(new Filament(null, "PLA+", "Yellow", 1000, "eSun", 22.89, "http://localhost:8080/filament/image/PLABlue.png", Status.FILAMENT_AVAILABLE));
			filamentRepository.save(new Filament(null, "PLA+", "White", 1000, "eSun", 18.99, "http://localhost:8080/filament/image/PLAWhite.png", Status.FILAMENT_UNAVAILABLE));
		};
	}

}
