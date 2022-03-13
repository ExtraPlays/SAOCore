package br.com.extraplays.saocore;

import br.com.extraplays.saocore.commands.ProfileCommand;
import br.com.extraplays.saocore.data.PlayerManager;
import br.com.extraplays.saocore.listeners.PlayerJoin;
import br.com.extraplays.saocore.teleport.TeleportManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class SAOCore extends JavaPlugin {

    @Getter
    private static SAOCore instance;

    @Getter TeleportManager teleportManager;
    @Getter PlayerManager playerManager;

    @Override
    public void onEnable() {
        instance = this;
        teleportManager = new TeleportManager();
        this.playerManager = new PlayerManager();

        registerEvents();
        registerCommands();
    }

    @Override
    public void onDisable() {
    }

    private void registerEvents(){
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
    }

    private void registerCommands(){
        getServer().getPluginCommand("profile").setExecutor(new ProfileCommand());
    }





}
