package ducktales.controllers;

import ducktales.data.UncleScroogeRepository;
import ducktales.models.SafeBox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DucktalesController {

    private final UncleScroogeRepository repository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public DucktalesController(UncleScroogeRepository _repository) {
        this.repository = _repository;
    }

    @RequestMapping(path = "/ducktales", method = RequestMethod.GET)
    public ResponseEntity<SafeBox> Get(@RequestParam String passphrase) {

        logger.info("ID do Repositório: " + repository.getID().toString());

        if (passphrase.isEmpty())
            return ResponseEntity.badRequest().build();

        SafeBox result = repository.getSafeBox();
        return ResponseEntity.ok(result);
    }
}