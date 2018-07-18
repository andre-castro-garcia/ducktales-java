package ducktales.data;

import ducktales.models.Coin;
import ducktales.models.SafeBox;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

import static java.util.concurrent.CompletableFuture.supplyAsync;

/*
    Annotation          Meaning
    -------------------------------------------------------------------------
    @Component          generic stereotype for any Spring-managed component
    @Repository         stereotype for persistence layer
    @Service            stereotype for service layer
    @Controller         stereotype for presentation layer (spring-mvc)
*/

@Scope(value="prototype", proxyMode=ScopedProxyMode.TARGET_CLASS)
@Service
public class UncleScroogeRepository implements IUncleScroogeRepository {

    private UUID ID = java.util.UUID.randomUUID();

    @Override
    public UUID getID() {
        return ID;
    }

    @Override
    public CompletableFuture<SafeBox> getSafeBox() {
        return supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return new SafeBox(new HashSet<>(Arrays.asList(
                    new Coin(0.01d, 0.25d),
                    new Coin(0.01d, 0.25d))));
        }, Executors.newFixedThreadPool(10));
    }
}
