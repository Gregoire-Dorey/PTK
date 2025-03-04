package fr.lenoob.ptk;

import fr.lenoob.ptk.commands.CommandStart;
import fr.lenoob.ptk.listeners.*;
import fr.lenoob.ptk.scoreboard.ScoreboardManager;
import fr.lenoob.ptk.utils.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class Main extends JavaPlugin {

    PluginManager pm = Bukkit.getPluginManager();
    public static Main instance;
    public ConfigManager config = new ConfigManager();
    Registerer reg = new Registerer(config);
    public Scoreboard sb ;
    public GameState current;
    public String prefix;
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
        current = GameState.WAIT;
        sb = Bukkit.getScoreboardManager().getNewScoreboard();
        config.generateConfig();
        registerHealth();
        reg.registerTeam();
        pm.registerEvents(new OnJoin(),this);
        pm.registerEvents(new OnBannerClick(),this);
        pm.registerEvents(new OnLeft(),this);
        pm.registerEvents(new TeamChoice(),this);
        pm.registerEvents(new BannerDrop(),this);
        pm.registerEvents(new CutClean(),this);
        pm.registerEvents(new CutCleanFood(),this);
        prefix = config.getConfigFile().getString("game.prefix");

        getCommand("start").setExecutor(new CommandStart());

        super.onEnable();
    }

    public GameState getCurrent() {
        return current;
    }

    public void setCurrent(GameState current) {
        this.current = current;
    }
    public boolean isCurrent(GameState state){
        return current == state;
    }

    public static Main getInstance() {
        return instance;
    }

    public String getPrefix() {
        return prefix.replaceAll("&","§");
    }
    public ScoreboardManager sm = new ScoreboardManager();

    public void registerHealth() {
        if(sb.getObjective("health")!= null) {
            sb.getObjective("helath").unregister();
        }
        Objective h = sb.registerNewObjective("health", "health");
        h.setDisplayName(ChatColor.RED+"♥");
        h.setDisplaySlot(DisplaySlot.BELOW_NAME);
    }
}
