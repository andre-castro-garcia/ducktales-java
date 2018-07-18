import ducktales.data.UncleScroogeRepository;
import ducktales.models.Coin;
import ducktales.models.SafeBox;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static com.ea.async.Async.await;

public class UncleScroogeRepositoryTest {

    private SafeBox safeBox = new SafeBox(new HashSet<>(Arrays.asList(
            new Coin(0.01d, 0.25d),
            new Coin(0.01d, 0.25d)
    )));

    private UncleScroogeRepository repository;

    @Before
    public void setup() {
        repository = new UncleScroogeRepository();
    }

    @Test
    public void shouldGetSafeBox() {
        SafeBox safeBoxActual = await(repository.getSafeBox());
        Assert.assertEquals(safeBox, safeBoxActual);
    }
}
