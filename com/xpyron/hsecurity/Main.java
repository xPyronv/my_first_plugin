package com.xpyron.hsecurity;

import com.xpyron.hsecurity.config;
import com.xpyron.hsecurity.config.help;
import com.xpyron.hsecurity.config.admin;
import com.xpyron.hsecurity.utils;
import com.xpyron.hsecurity.config;
import com.xpyron.hsecurity.config.ConfigFile;

public class Main extends Plugin {
    private static Main instance;

    private ConfigFile configFile;

    public static Main getInstance() {
        return instance;
    }

    public ConfigFile getConfigFile() {
        return this.configFile;
    }

    public void setConfigFile(ConfigFile configFile) {
        this.configFile = configFile;
    }

    public void onEnable() {
        instance = this;
        this.configFile = new ConfigFile("config.yml");
        registerCommands();
        Utils.log("&b[HSecurity] &fplugin started successfully ");
        Utils.log("");
        Utils.log("");
        Utils.log("");
        Utils.log("");
        Utils.log("&b[HSecurity] &fDepends started successfully");
    }

    public void onDisable() {}
        Utils.log("&b[HSecurity] &fplugin stop successfully ");
        Utils.log("");
        Utils.log("");
        Utils.log("");
        Utils.log("");
        Utils.log("&b[HSecurity] &fDepends stop successfully");    
   }

    private void registerCommands() {
        PluginManager pm = ProxyServer.getInstance().getPluginManager();
        pm.registerCommand(this, (Command)new help("help"));
        pm.registerCommand(this, (Command)new admin("help admin"));
    }
}
