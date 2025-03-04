package fr.lenoob.ptk.utils;

import fr.lenoob.ptk.Main;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.Team;

public class UtilsMethods {
    public ConfigManager cfg = Main.getInstance().config;
    public FileConfiguration file = cfg.getConfigFile();

    public UtilsMethods() {
    }

    public void start(Player player){
        Team noTeam = Main.getInstance().sb.getTeam("No Team");
        if(noTeam.getEntries().size()<=0){
            World w = Bukkit.getWorld("world");
            w.setTime(0);
            w.setDifficulty(Difficulty.NORMAL);
            w.setGameRuleValue("doDaylightCycle", "true");
            ItemStack apple = new ItemStack(Material.APPLE,10);
            ItemStack steak = new ItemStack(Material.COOKED_BEEF,10);
            Bukkit.broadcastMessage(Main.getInstance().getPrefix()+" La partie commence");
            Bukkit.broadcastMessage(Main.getInstance().getPrefix()+" Les rois pour la partie sont les suivants : ");
            for(Player ps : Bukkit.getOnlinePlayers()){
                ps.getInventory().clear();
                ps.getInventory().addItem(apple);
                ps.getInventory().addItem(steak);
            }
            for(String purple : Main.getInstance().sb.getTeam("purple").getEntries()){
                Player team = Bukkit.getPlayer(purple);
                this.teleportPurple(team);
            }
            for(String blue : Main.getInstance().sb.getTeam("blue").getEntries()){
                Player team = Bukkit.getPlayer(blue);
                this.teleportBlue(team);
            }
            for(String yellow : Main.getInstance().sb.getTeam("yellow").getEntries()){
                Player team = Bukkit.getPlayer(yellow);
                this.teleportYellow(team);
            }
        }else {
            player.sendMessage(Main.getInstance().getPrefix()+"Les joueurs suivant ne possèdent pas d'équipe : ");
            for(String name : noTeam.getEntries()){
                player.sendMessage(Main.getInstance().getPrefix()+"- "+name);
            }
        }
    }

    public void teleportBlue(Player player){
        player.teleport(new Location(Bukkit.getWorld("world"),file.getDouble("teams.blue.base.x"),file.getDouble("teams.blue.base.y"),file.getDouble("teams.blue.base.z")));
    }

    public void teleportPurple(Player player){
        player.teleport(new Location(Bukkit.getWorld("world"),file.getDouble("teams.purple.base.x"),file.getDouble("teams.purple.base.y"),file.getDouble("teams.purple.base.z")));
    }

    public void teleportYellow(Player player){
        player.teleport(new Location(Bukkit.getWorld("world"),file.getDouble("teams.yellow.base.x"),file.getDouble("teams.yellow.base.y"),file.getDouble("teams.yellow.base.z")));
    }
}
