import ducktales.controllers.DucktalesController;
import ducktales.data.IUncleScroogeRepository;
import ducktales.models.Coin;
import ducktales.models.SafeBox;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.CompletableFuture;

import static com.ea.async.Async.await;

public class DucktalesControllerTest {

    private DucktalesController controller;

    private SafeBox safeBox = new SafeBox(new HashSet<>(Arrays.asList(
            new Coin(0.01d, 0.25d),
                new Coin(0.01d, 0.25d)
        )));

    @Mock
    private IUncleScroogeRepository repository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(repository.getSafeBox()).thenReturn(CompletableFuture.completedFuture(safeBox));

        controller = new DucktalesController(repository);
    }

    @Test
    public void shouldGetSafeBox() {
        String passphrase = "123";
        SafeBox response = await(controller.Get(passphrase)).getBody();

        assert response != null;
        Assert.assertEquals(2, response.getCoins().size());
    }
}
