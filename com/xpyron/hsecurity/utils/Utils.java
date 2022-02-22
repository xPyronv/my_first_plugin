package com.xpyron.hsecurity.utils;

import com.xpyron.hsecurity.Main;
import com.xpyron.hsecurity.config.ConfigFile;
import org.bukkit.api.ChatColor;
import org.bukkit.ChatColor;

public final class Utils {
    private Utils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static void log(String message) {
        Main.getInstance().getLogger().info(colorize(message));
    }

    public static String colorize(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}

