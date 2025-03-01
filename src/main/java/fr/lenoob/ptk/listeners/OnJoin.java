package fr.lenoob.ptk.listeners;

import fr.lenoob.ptk.Main;
import fr.lenoob.ptk.utils.ConfigManager;
import fr.lenoob.ptk.utils.GameState;
import fr.lenoob.ptk.utils.Registerer;

import fr.lenoob.ptk.utils.Tablist;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
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
        Tablist.sendTablist(player,cfg.getConfigFile().getString("game.tablist.header").replaceAll("&","§"),
                cfg.getConfigFile().getString("game.tablist.footer1").replaceAll("&","§"),
                cfg.getConfigFile().getString("game.tablist.footer2").replaceAll("&","§"));
        if(Main.getInstance().isCurrent(GameState.WAIT)){
            ItemStack banner = new ItemStack(Material.BANNER,1,(short) 15);
            ItemMeta bannerM = banner.getItemMeta();
            bannerM.setDisplayName("§6§lChoix de la team");
            banner.setItemMeta(bannerM);
            player.getInventory().clear();
            player.getInventory().setItem(4,banner);
        }
    }

}
