package fr.lenoob.ptk.listeners;

import fr.lenoob.ptk.Main;
import fr.lenoob.ptk.utils.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.Team;

import java.util.List;

public class OnBannerClick implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent event){
        ConfigManager cfg = Main.getInstance().config;
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInHand();
        Action action = event.getAction();
        if(item == null)return;
        if(item.getType() == Material.BANNER && item.getItemMeta().getDisplayName().equals("§6§lChoix de la team")) {
            if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK){
                event.setCancelled(true);
                Inventory inv = Bukkit.createInventory(null, 9,"§3§lChoix de la team");
                if(cfg.getConfigFile().getBoolean("teams.yellow.enabled")){
                    ItemStack jaune = new ItemStack(Material.WOOL,1,(short) 4);
                    ItemMeta jauneM = jaune.getItemMeta();
                    jauneM.setDisplayName(ChatColor.GOLD+"Choisir l'équipe §eJaune");
                    jaune.setItemMeta(jauneM);
                    inv.setItem(1,jaune);
                }
                if(cfg.getConfigFile().getBoolean("teams.purple.enabled")){
                    ItemStack purple = new ItemStack(Material.WOOL,1,(short) 10);
                    ItemMeta purpleM = purple.getItemMeta();
                    purpleM.setDisplayName(ChatColor.GOLD+"Choisir l'équipe §5Violette");
                    purple.setItemMeta(purpleM);
                    inv.setItem(4,purple);
                }
                if(cfg.getConfigFile().getBoolean("teams.blue.enabled")){
                    ItemStack blue = new ItemStack(Material.WOOL,1,(short) 11);
                    ItemMeta blueM = blue.getItemMeta();
                    blueM.setDisplayName(ChatColor.GOLD+"Choisir l'équipe §1Bleu");
                    blue.setItemMeta(blueM);
                    inv.setItem(7,blue);
                }
                player.openInventory(inv);
            }
        }
    }
}
