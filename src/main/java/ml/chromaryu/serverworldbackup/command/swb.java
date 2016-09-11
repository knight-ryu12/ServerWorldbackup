package ml.chromaryu.serverworldbackup.command;

import ml.chromaryu.serverworldbackup.api.compressTarGz;
import ml.chromaryu.serverworldbackup.main;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;


/**
 * Created by ryuniverse on 2016/09/06.
 */
public class swb implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(commandSender instanceof Player) {
            Player p = (Player) commandSender;
            Logger logger = Bukkit.getLogger();
            if(args.length >= 1) {
                if (args[0].equalsIgnoreCase("saveworld")) {
                    long initTime = System.currentTimeMillis();
                    p.sendMessage(main.prefix + "Saving the current world!");
                    String filename = main.dir + "/" + p.getWorld().getName() + " " +new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US).format(Calendar.getInstance().getTime()) + ".tar.gz";
                    List<Path> fileList = new ArrayList<>();
                    FileVisitor<Path> visitor = new SimpleFileVisitor<Path>() {
                        @Override
                        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                            fileList.add(file);
                            return FileVisitResult.CONTINUE;
                        }
                    };
                    try {
                        Files.walkFileTree(new File(p.getWorld().getWorldFolder().getPath().substring(2)).toPath(), visitor);
                        compressTarGz.compresstargz(fileList, filename);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    initTime = System.currentTimeMillis() - initTime;
                    p.sendMessage(main.prefix + "Done in " + initTime + "ms");
                    return true;
                }
                if (args[0].equalsIgnoreCase("saveallworld")) {
                    // TODO: 16/09/11 Impliment "get all World"
                    return true;
                }
                if (args[0].equalsIgnoreCase("test")) {
                    p.sendMessage(p.spigot().getLocale());
                }
            } else {
                p.sendMessage(main.prefix + "");
                return true;
            }
        } else {
            Bukkit.getLogger().info("Use this command in-game!");
            return false;
        }
        return false;
    }
}
