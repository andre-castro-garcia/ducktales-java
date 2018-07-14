package ducktales.data;

import ducktales.models.SafeBox;
import org.springframework.stereotype.Repository;

@Repository
public interface IUncleScroogeRepository {
    SafeBox getSafeBox();
}
