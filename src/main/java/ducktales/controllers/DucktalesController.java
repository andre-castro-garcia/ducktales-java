package ducktales.controllers;

import ducktales.data.IUncleScroogeRepository;
import ducktales.models.SafeBox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.CompletableFuture;

import static com.ea.async.Async.await;
import static java.util.concurrent.CompletableFuture.completedFuture;

@RestController
public class DucktalesController {

    private final IUncleScroogeRepository repository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public DucktalesController(IUncleScroogeRepository _repository) {
        this.repository = _repository;
    }

    @RequestMapping(path = "/ducktales", method = RequestMethod.GET)
    public CompletableFuture<ResponseEntity<SafeBox>> Get(@RequestParam String passphrase) {

        logger.info("ID do Repositório: " + repository.getID().toString());

        if (passphrase.isEmpty())
            return completedFuture(ResponseEntity.badRequest().build());

        SafeBox result = await(repository.getSafeBox());
        return completedFuture(ResponseEntity.ok(result));
    }
}