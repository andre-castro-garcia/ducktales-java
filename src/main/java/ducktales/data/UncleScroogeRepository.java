package ducktales.data;

import ducktales.models.Coin;
import ducktales.models.SafeBox;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@Scope(value = "prototype")
@Component
public class UncleScroogeRepository implements IUncleScroogeRepository {

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
