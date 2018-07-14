package ducktales.models;

import java.util.Set;

public class SafeBox {

    private Set<Coin> Coins;

    public SafeBox(Set<Coin> coins) {
        Coins = coins;
    }

    public Set<Coin> getCoins() {
        return Coins;
    }

    @Override
    public boolean equals(Object obj) {
        return this.Coins.size() == ((SafeBox)obj).Coins.size();
    }
}
