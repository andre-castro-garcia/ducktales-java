import ducktales.controllers.DucktalesController;
import ducktales.data.UncleScroogeRepository;
import ducktales.models.Coin;
import ducktales.models.SafeBox;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DucktalesControllerTest {

    private DucktalesController controller;

    private final SafeBox safeBox = new SafeBox(new HashSet<>(Arrays.asList(
            new Coin(0.01d, 0.25d),
                new Coin(0.01d, 0.25d)
        )));

    @Mock
    private UncleScroogeRepository repository;

    @BeforeEach
    public void setup() {
        repository = mock(UncleScroogeRepository.class);
        when(repository.getSafeBox()).thenReturn(safeBox);
        when(repository.getID()).thenReturn(java.util.UUID.randomUUID());

        controller = new DucktalesController(repository);
    }

    @Test
    public void shouldGetSafeBox() {
        String passphrase = "123";
        ResponseEntity<SafeBox> response = controller.Get(passphrase);

        assertNotNull(response);
        assertEquals(2, Objects.requireNonNull(response.getBody()).getCoins().size());
    }
}
