package ducktales.controllers;

import ducktales.data.IUncleScroogeRepository;
import ducktales.models.SafeBox;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DucktalesController {

    private final IUncleScroogeRepository repository;

    public DucktalesController(IUncleScroogeRepository _repository) {
        this.repository = _repository;
    }

    @RequestMapping(path = "/ducktales", method = RequestMethod.GET)
    public SafeBox Get() {
        return repository.getSafeBox();
    }

}