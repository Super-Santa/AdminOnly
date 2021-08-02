package me.supersanta.adminonly;

import me.supersanta.adminonly.Commands.CommandAo;
import me.supersanta.adminonly.Listeners.JoinLeaveListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class AdminOnly extends JavaPlugin {

    @Override
    public void onEnable() {

        //Config
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        //Commands
        getCommand("ao").setExecutor(new CommandAo());

        //Listeners
        getServer().getPluginManager().registerEvents(new JoinLeaveListener(), this);

    }
}
