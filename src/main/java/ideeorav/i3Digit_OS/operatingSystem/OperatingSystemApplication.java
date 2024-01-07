package ideeorav.i3Digit_OS.operatingSystem;

import ideeorav.i3Digit_OS.operatingSystem.enumeration.Status;
import ideeorav.i3Digit_OS.operatingSystem.model.Filament;
import ideeorav.i3Digit_OS.operatingSystem.repository.FilamentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

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

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "Filename"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

}
