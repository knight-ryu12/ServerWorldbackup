package ml.chromaryu.serverworldbackup;

import ml.chromaryu.serverworldbackup.command.swb;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

/**
 * Created by ryuniverse on 2016/09/06.
 */
public class main extends JavaPlugin {
    long initTime;
    File config;
    public void onEnable() {
        initTime = System.currentTimeMillis(); // get Time in millis to determine how much time did this plugin take to initialize
        getCommand("swb").setExecutor(new swb());
        saveDefaultConfig();
        config = new File(getDataFolder(),"config.yml");
        initTime = initTime - System.currentTimeMillis();
        getLogger().info("Initialization was completed in" + initTime +"ms.");
    }


    @Override
    public void onDisable() {
        getLogger().info("Plugin successfully unloaded!");
    }

}
