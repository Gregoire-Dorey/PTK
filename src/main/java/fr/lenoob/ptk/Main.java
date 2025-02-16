package fr.lenoob.ptk;

import fr.lenoob.ptk.listeners.OnJoin;
import fr.lenoob.ptk.utils.ConfigManager;
import fr.lenoob.ptk.utils.Registerer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;

public class Main extends JavaPlugin {

    PluginManager pm = Bukkit.getPluginManager();
    public static Main instance;
    ConfigManager config = new ConfigManager();
    Registerer reg = new Registerer(config);
    public Scoreboard sb ;

    @Override
    public void onLoad() {
        instance = this;
        super.onLoad();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void onEnable() {
        sb = Bukkit.getScoreboardManager().getNewScoreboard();
        config.generateConfig();
        reg.registerTeam();
        pm.registerEvents(new OnJoin(),this);
        super.onEnable();
    }

    public static Main getInstance() {
        return instance;
    }

}
