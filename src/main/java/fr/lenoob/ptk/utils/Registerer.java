package fr.lenoob.ptk.utils;

import fr.lenoob.ptk.Main;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.Set;

public class Registerer {

    private ConfigManager configManager;
    public ArrayList<String> teamList = new ArrayList<>();

    public Registerer(ConfigManager configManager) {
        this.configManager = configManager;
    }

    public void registerTeam() {
        FileConfiguration config = configManager.getConfigFile();
        Set<String> keys = config.getKeys(true);
        for (String key : keys){
            if(key.startsWith("teams.") && key.endsWith(".enabled")){
                if(config.getBoolean(key)){
                    key = key.replaceAll("teams.","");
                    key = key.replaceAll(".enabled","");
                    teamList.add(key);
                }
            }
        }
        for (String team : teamList){
            Team  newTeam = Main.getInstance().sb.registerNewTeam(team);
            newTeam.setPrefix(configManager.getConfigFile().getString("teams."+team+".prefix").replaceAll("&","§"));
            newTeam.setDisplayName(configManager.getConfigFile().getString("teams."+team+".prefix").replaceAll("&","§"));
            newTeam.setAllowFriendlyFire(true);
            System.out.println("La team "+newTeam.getName()+" a ete cree avec succes");
        }
    }

    public ArrayList<String> getTeamList() {
        return teamList;
    }
}
