package com.xpyron.hsecurity.config;

import com.xpyron.hsecurity.Main;
import com.xpyron.hsecurity.utils;

public class ConfigFile {
    private File file;

    private Configuration configuration;

    public ConfigFile(String name) {
        if (!Main.getInstance().getDataFolder().exists())
            Main.getInstance().getDataFolder().mkdir();
        this.file = new File(Main.getInstance().getDataFolder(), name);
        if (!this.file.exists())
            try (InputStream in = Main.getInstance().getResourceAsStream("config.yml")) {
                Files.copy(in, this.file.toPath(), new java.nio.file.CopyOption[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        try {
            this.configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(this.file);
        } catch (IOException e) {
            Stream.<String>of(e.getMessage().split("\n")).forEach(Utils::log);
        }
    }

    public void save() {
        try {
            ConfigurationProvider.getProvider(YamlConfiguration.class).save(this.configuration, this.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() {
        try {
            this.configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(this.file);
        } catch (IOException e) {
            Stream.<String>of(e.getMessage().split("\n")).forEach(Utils::log);
        }
    }

    public String getString(String path) {
        return this.configuration.getString(path);
    }

    public boolean getBoolean(String path) {
        return this.configuration.getBoolean(path);
    }

    public List<String> getStringList(String path) {
        return this.configuration.getStringList(path);
    }
}
