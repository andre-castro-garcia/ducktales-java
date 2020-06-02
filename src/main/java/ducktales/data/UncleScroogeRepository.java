package ducktales.data;

import ducktales.models.Coin;
import ducktales.models.SafeBox;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;

/*
    Annotation          Meaning
    -------------------------------------------------------------------------
    @Component          generic stereotype for any Spring-managed component
    @Repository         stereotype for persistence layer
    @Service            stereotype for service layer
    @Controller         stereotype for presentation layer (spring-mvc)
*/

@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Service
public class UncleScroogeRepository {

    private final UUID ID = java.util.UUID.randomUUID();

    public UUID getID() {
        return ID;
    }

    public SafeBox getSafeBox() {
        return new SafeBox(new HashSet<>(Arrays.asList(
                new Coin(0.01d, 0.25d),
                new Coin(0.01d, 0.25d))));
    }
}
