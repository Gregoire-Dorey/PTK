package fr.lenoob.ptk.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

public class Teams {

    public String name;
    public String color;
    private ArrayList<UUID> entries;

    public Teams(String name, String color) {
        this.name = name;
        this.color = color;

    }

    public void addPlayer(Player player){
        entries.add(player.getUniqueId());
        player.setPlayerListName(ChatColor.valueOf(color)+""+player.getDisplayName());
    }

    public void removePlayer(Player player){
        entries.remove(player.getUniqueId());
        player.setPlayerListName(ChatColor.WHITE+""+player.getDisplayName());
    }
}
