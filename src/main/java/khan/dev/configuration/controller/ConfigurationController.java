package khan.dev.configuration.controller;

import khan.dev.configuration.service.ConfigurationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("${application.url.path}")
@RequiredArgsConstructor
public class ConfigurationController {

    private final ConfigurationService service;

    @GetMapping
    public ResponseEntity<?> getReadFile() throws IOException {
        return ResponseEntity.ok(service.getConfiguration());
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getReadFile(@PathVariable String name) throws IOException {
        return ResponseEntity.ok(service.getConfiguration(name));
    }

}
