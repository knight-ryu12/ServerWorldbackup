package ml.chromaryu.serverworldbackup.command;

import ml.chromaryu.serverworldbackup.main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by chroma on 16/09/12.
 */
public class swb_help {
    public static void help(Player p) {
        if(p.spigot().getLocale().equalsIgnoreCase("en_US")) {
            p.sendMessage(main.prefix + " Command List ");
            p.sendMessage(main.prefix + " saveworld: Save current world");
            p.sendMessage(main.prefix + " saveallworld: Save all world");
            p.sendMessage(main.prefix + ChatColor.RED +" Use command in-game!");
        } else {
            p.sendMessage(main.prefix + " コマンドリスト");
            p.sendMessage(main.prefix + " saveworld: 自分がいるワールドを保存します");
            p.sendMessage(main.prefix + " saveallworld: すべてのワールドを保存します");
            p.sendMessage(main.prefix + ChatColor.RED + " インゲームでコマンドを使ってください");
        }
    }
}
