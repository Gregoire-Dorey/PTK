package fr.lenoob.ptk.utils;

import fr.lenoob.ptk.Main;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.Team;

public class UtilsMethods {

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
        }else {
            player.sendMessage(Main.getInstance().getPrefix()+"Les joueurs suivant ne possèdent pas d'équipe : ");
            for(String name : noTeam.getEntries()){
                player.sendMessage(Main.getInstance().getPrefix()+"- "+name);
            }
        }
    }
}
