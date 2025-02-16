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
        ConfigManager cfg = new ConfigManager();
        Registerer reg = new Registerer(cfg);
        Player player = event.getPlayer();
        Team jaune = Main.getInstance().sb.getTeam("yellow");
        jaune.addEntry(player.getName());
        Bukkit.broadcastMessage("Le joueur "+player.getName()+" à été ajouté a la team "+jaune.getName());
        Bukkit.broadcastMessage("Il se nomme desormais "+player.getDisplayName());
        System.out.println(Main.getInstance().sb.getTeams());
        System.out.println(Main.getInstance().sb.getTeam("yellow").getEntries());
        System.out.println(Main.getInstance().sb.getTeam("yellow").getPrefix());
        Bukkit.broadcastMessage(Main.getInstance().sb.getTeam("yellow").getPrefix());
    }

}
