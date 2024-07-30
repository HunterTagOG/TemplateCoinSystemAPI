package de.huntertagog.locobrokoi.commads;

import de.huntertagog.locobroko.api.ICoinAPI;
import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CoinCommand implements CommandExecutor {

    private final ICoinAPI coinAPI;

    public CoinCommand(ICoinAPI coinAPI) {
        this.coinAPI = coinAPI;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) return false;
        int coins = coinAPI.getCoins(player.getUniqueId());
        player.sendMessage(Component.text("Du hast " + coins + " Coins!"));
        return true;
    }
}
