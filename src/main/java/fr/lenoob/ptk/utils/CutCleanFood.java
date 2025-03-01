package fr.lenoob.ptk.utils;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;


public class CutCleanFood implements Listener {
	
	@EventHandler
	public void onEntityDeath(EntityDeathEvent e) {
		Random r = new Random();
		int alea = r.nextInt(2);
		if(e.getEntity().getType() == EntityType.COW) {
			e.getDrops().clear();
			e.getDrops().add(new ItemStack(Material.COOKED_BEEF));
			e.getDrops().add(new ItemStack(Material.LEATHER,alea));
		}else if(e.getEntity().getType() == EntityType.SHEEP) {
			e.getDrops().clear();
			e.getDrops().add(new ItemStack(Material.COOKED_MUTTON));
			e.getDrops().add(new ItemStack(Material.WOOL));
		}else if(e.getEntity().getType() == EntityType.CHICKEN) {
			e.getDrops().clear();
			e.getDrops().add(new ItemStack(Material.COOKED_CHICKEN));
			e.getDrops().add(new ItemStack(Material.ARROW,alea));
		}else if(e.getEntity().getType() == EntityType.PIG) {
			e.getDrops().clear();
			e.getDrops().add(new ItemStack(Material.GRILLED_PORK));
		}else {
			return;
		}
	}
	

}
