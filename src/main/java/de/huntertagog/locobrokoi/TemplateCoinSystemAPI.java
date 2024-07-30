package de.huntertagog.locobrokoi;

import de.huntertagog.locobroko.api.CoinAPI;
import de.huntertagog.locobroko.api.ICoinAPI;
import de.huntertagog.locobrokoi.commads.CoinCommand;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class TemplateCoinSystemAPI extends JavaPlugin {

    @Getter
    private static ICoinAPI coinAPI;

    @Override
    public void onEnable() {
        coinAPI = CoinAPI.getApi();
        if (coinAPI == null) {
            getLogger().severe("CoinAPI not found!");
        }

        // Registriere Commands
        Objects.requireNonNull(getCommand("coins")).setExecutor(new CoinCommand(coinAPI));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        coinAPI = null;
    }
}
