package ducktales.data;

import ducktales.models.SafeBox;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface IUncleScroogeRepository {

    CompletableFuture<SafeBox> getSafeBox();

    UUID getID();
}
