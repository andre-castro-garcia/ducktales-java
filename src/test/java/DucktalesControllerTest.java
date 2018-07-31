import com.ea.async.Async;
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
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
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
        Mockito.when(repository.getID()).thenReturn(java.util.UUID.randomUUID());

        controller = new DucktalesController(repository);
        Async.init();
    }

    @Test
    public void shouldGetSafeBox() {
        String passphrase = "123";
        ResponseEntity<SafeBox> response = await(controller.Get(passphrase));

        Assert.assertNotNull(response);
        Assert.assertEquals(2, Objects.requireNonNull(response.getBody()).getCoins().size());
    }
}
