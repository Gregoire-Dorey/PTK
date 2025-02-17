package fr.lenoob.ptk.listeners;

import fr.lenoob.ptk.Main;
import fr.lenoob.ptk.utils.ConfigManager;
import fr.lenoob.ptk.utils.Registerer;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Team;

public class OnJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        ConfigManager cfg = Main.getInstance().config;
        Player player = event.getPlayer();
        player.setScoreboard(Main.getInstance().sb);
        event.setJoinMessage("");
        int j = Bukkit.getOnlinePlayers().size();
        int m = Bukkit.getMaxPlayers();
        Bukkit.broadcastMessage(cfg.getConfigFile().getString("game.prefix").replaceAll("&","§")+player.getDisplayName()+" §2à rejoins la partie §8[§2"+j+"§8/§2"+m+"§8]");
    }

}
