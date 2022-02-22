package com.xpyron.hsecurity.commands;

import com.xpyron.hsecurity.Main;
import com.xpyron.hsecurity.config.ConfigFile;
import com.xpyron.hsecurity.utils.Utils;
import org.Bukkit.CommandSender;
import org.Bukkit.chat.BaseComponent;
import org.Bukkit.chat.TextComponent;
import org.Bukkit.connection.ProxiedPlayer;
import org.Bukkit.plugin.Command;

public class vAdminCMD extends Command {
    public vAdminCMD(String name) {
        super(name);
    }

    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer player = (ProxiedPlayer)sender;
        ConfigFile configFile = Main.getInstance().getConfigFile();
        if (!player.hasPermission("hsecurity.adminreload")) {
            player.sendMessage((BaseComponent)new TextComponent(Utils.colorize(configFile.getString("messages.no-permission"))));
            return;
        }
        if (args.length == 0) {
            player.sendMessage((BaseComponent)new TextComponent(Utils.colorize(configFile.getString("messages.no-args"))));
            return;
        }
        if (args[0].equalsIgnoreCase("reload")) {
            Main.getInstance().setConfigFile(new ConfigFile("config.yml"));
            player.sendMessage((BaseComponent)new TextComponent(Utils.colorize("&b[HSecurity] &8&l» &aThe plugin was successfully reloaded")));
        }
    }
}
