package fr.lenoob.ptk.utils;

import fr.lenoob.ptk.Main;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;


public class ConfigManager {
    private File configuration;
    private FileConfiguration configFile;

    public ConfigManager() {
    }
    public FileConfiguration getConfigFile(){
        return configFile;
    }

    public void generateConfig(){
        configuration = new File(Main.getInstance().getDataFolder(),"game.yml");
        if(!configuration.exists()){
            configuration.getParentFile().mkdirs();
            Main.getInstance().saveResource("game.yml",false);
        }
        configFile = new YamlConfiguration();
        try {
            configFile.load(configuration);
        }catch (IOException | InvalidConfigurationException e){
            e.printStackTrace();
        }
    }





}
