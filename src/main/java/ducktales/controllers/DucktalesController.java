package ducktales.controllers;

import ducktales.data.IUncleScroogeRepository;
import ducktales.models.SafeBox;
import org.springframework.beans.factory.annotation.Qualifier;
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

    public DucktalesController(@Qualifier("uncleScroogeRepository") IUncleScroogeRepository _repository) {
        this.repository = _repository;
    }

    @RequestMapping(path = "/ducktales", method = RequestMethod.GET)
    public CompletableFuture<ResponseEntity<SafeBox>> Get(@RequestParam String passphrase) {

        if (passphrase.isEmpty())
            return completedFuture(ResponseEntity.badRequest().build());

        SafeBox result = await(repository.getSafeBox());
        return completedFuture(ResponseEntity.ok(result));
    }
}