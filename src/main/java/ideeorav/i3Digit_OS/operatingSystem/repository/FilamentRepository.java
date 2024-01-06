package ideeorav.i3Digit_OS.operatingSystem.repository;

import ideeorav.i3Digit_OS.operatingSystem.model.Filament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilamentRepository extends JpaRepository<Filament, Long> {

    Filament findByType(String type);
    Filament findByColor(String color);
    Filament findByProducer(String producer);

}
