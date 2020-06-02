import ducktales.data.UncleScroogeRepository;
import ducktales.models.Coin;
import ducktales.models.SafeBox;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UncleScroogeRepositoryTest {

    private final SafeBox safeBox = new SafeBox(new HashSet<>(Arrays.asList(
            new Coin(0.01d, 0.25d),
            new Coin(0.01d, 0.25d)
    )));

    private UncleScroogeRepository repository;

    @BeforeEach
    public void setup() {
        repository = new UncleScroogeRepository();
    }

    @Test
    public void shouldGetSafeBox() {
        SafeBox safeBoxActual = repository.getSafeBox();
        assertEquals(safeBox, safeBoxActual);
    }
}
