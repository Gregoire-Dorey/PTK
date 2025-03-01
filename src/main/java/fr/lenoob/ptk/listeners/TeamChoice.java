package fr.lenoob.ptk.listeners;

import fr.lenoob.ptk.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.Team;

public class TeamChoice implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event){
        Inventory inv = event.getClickedInventory();
        ItemStack item = event.getCurrentItem();
        Player player = (Player) event.getWhoClicked();
        Team jaune = Main.getInstance().sb.getTeam("yellow");
        Team bleu = Main.getInstance().sb.getTeam("blue");
        Team violette = Main.getInstance().sb.getTeam("purple");
        if(inv == null)return;
        if(inv.getName().equalsIgnoreCase("§3§lChoix de la team")) {
            event.setCancelled(true);
            if(item == null) return;
            if(item.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD+"Choisir l'équipe §eJaune")){
                jaune.addEntry(player.getDisplayName());
                String name = item.getItemMeta().getDisplayName().replace("Choisir l'équipe","");
                player.sendMessage(Main.getInstance().getPrefix()+"Vous avez rejoins la team"+name);
            }
            if(item.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD+"Choisir l'équipe §5Violette")){
                String name = item.getItemMeta().getDisplayName().replace("Choisir l'équipe","");
                player.sendMessage(Main.getInstance().getPrefix()+"Vous avez rejoins la team"+name);
                violette.addEntry(player.getDisplayName());
            }
            if(item.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD+"Choisir l'équipe §1Bleu")){
                bleu.addEntry(player.getDisplayName());
                String name = item.getItemMeta().getDisplayName().replace("Choisir l'équipe","");
                player.sendMessage(Main.getInstance().getPrefix()+"Vous avez rejoins la team"+name);
            }

        }
        if(inv == player.getInventory()){
            if(item == null) return;
            if(item.getType() == Material.BANNER){
                event.setCancelled(true);
            }
        }
    }

}
