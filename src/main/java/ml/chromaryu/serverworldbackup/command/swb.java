package ml.chromaryu.serverworldbackup.command;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ryuniverse on 2016/09/06.
 */
public class swb implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if(args[0].equals("saveworld")) {
                World w = p.getWorld();
                File worldFile = w.getWorldFolder();
                File[] files = worldFile.listFiles();
                for (File f: files) {
                    Bukkit.getLogger().info(f.getPath());
                }
                return true;
            }
        }
        return false;
    }
}
