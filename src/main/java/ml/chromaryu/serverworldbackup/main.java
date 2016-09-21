package ml.chromaryu.serverworldbackup;

import ml.chromaryu.serverworldbackup.command.swb;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Logger;

/**
 * Created by ryuniverse on 2016/09/06.
 */
public class main extends JavaPlugin {
    long initTime;

    public static File config;
    public static String backupdir;
    public static String prefix;
    public static Logger logger;
    public static File dir;
    public void onEnable() {
        initTime = System.currentTimeMillis(); // get Time in millis to determine how much time did this plugin take to initialize
        getCommand("swb").setExecutor(new swb());
        logger = getLogger();
        dir = getDataFolder();
        getLogger().info(dir.toString() + " " + dir.toPath());
        createConfig();
        backupdir = getConfig().getString("BackupDirectory");
        File file = new File(getDataFolder()+"/" + backupdir);
        if(file.mkdir()) {
            getLogger().info("Directory has been made");
        }
        prefix = ChatColor.translateAlternateColorCodes('&',getConfig().getString("Pluginprefix"));
        //config = new File(getDataFolder(),"config.yml");
        initTime = System.currentTimeMillis() - initTime;
        getLogger().info("Initialization was completed in" + initTime +"ms.");
    }


    @Override
    public void onDisable() {
        getLogger().info("Plugin successfully unloaded!");
    }

    private void createConfig() {
        try {
            config = new File(getDataFolder(), "config.yml");
            if (!config.exists()) {
                getLogger().info("Config.yml not found, creating!");
                saveDefaultConfig();
            } else {
                getLogger().info("Config.yml found, loading!");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
