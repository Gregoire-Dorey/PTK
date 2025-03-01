package fr.lenoob.ptk.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class BannerDrop implements Listener {

    @EventHandler
    public void onBannerDrop(PlayerDropItemEvent event){
        ItemStack item = event.getItemDrop().getItemStack();
        if(item == null)return;
        if (item.getType().equals(Material.BANNER)) {
            if(item.getItemMeta().getDisplayName() == null)return;
            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("§6§lChoix de la team") && item.getItemMeta().getDisplayName() != null){
                event.setCancelled(true);
            }
        }
    }

}
