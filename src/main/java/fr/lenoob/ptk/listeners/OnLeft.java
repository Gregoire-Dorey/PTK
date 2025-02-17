package fr.lenoob.ptk.listeners;

import fr.lenoob.ptk.Main;
import fr.lenoob.ptk.utils.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class OnLeft implements Listener {

    @EventHandler
    public void onLeft(PlayerQuitEvent event){
        ConfigManager cfg = Main.getInstance().config;
        Player player = event.getPlayer();
        event.setQuitMessage("");
        int j = Bukkit.getOnlinePlayers().size()-1;
        int m = Bukkit.getMaxPlayers();
        Bukkit.broadcastMessage(cfg.getConfigFile().getString("game.prefix").replaceAll("&","§")+player.getDisplayName()+" §cà quitter la partie §8[§c"+j+"§8/§c"+m+"§8]");
    }

}
