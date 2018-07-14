package ducktales.data;

import ducktales.models.Coin;
import ducktales.models.SafeBox;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;

@Component
public class UncleScroogeRepository implements IUncleScroogeRepository {

    @Override
    public SafeBox getSafeBox() {

        return new SafeBox(new HashSet<>(Arrays.asList(
                new Coin(0.01d, 0.25d),
                new Coin(0.01d, 0.25d)
        )));
    }
}
