package ideeorav.i3Digit_OS.operatingSystem.resource;

import ideeorav.i3Digit_OS.operatingSystem.model.Filament;
import ideeorav.i3Digit_OS.operatingSystem.model.Response;
import ideeorav.i3Digit_OS.operatingSystem.service.implementation.FilamentServiceImplementation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;


@RestController
@RequestMapping("/filament")
@RequiredArgsConstructor
public class FilamentResource {

    private final FilamentServiceImplementation filamentService;

    @GetMapping("/list")
    public ResponseEntity<Response> getFilaments(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("filaments", filamentService.list(50)))
                        .message("Filaments retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveFilament(@RequestBody @Valid Filament filament){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("filament", filamentService.create(filament)))
                        .message("Filament created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getFilament(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("filament", filamentService.get(id)))
                        .message("Filament retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteFilament(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("deleted", filamentService.delete(id)))
                        .message("Filament deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping(path= "/image/{fileName}", produces = IMAGE_PNG_VALUE)
    public byte[] getFilamentImage(@PathVariable("fileName") String fileName) throws IOException {
        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/Desktop/I3DigitOS/FilamentImages/" + fileName));
    }

}
