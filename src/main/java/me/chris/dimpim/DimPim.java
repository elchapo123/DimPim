package me.chris.dimpim;

import me.chris.dimpim.listeners.ChunkLoadListener;
import me.chris.dimpim.listeners.PlayerChatListener;
import me.chris.dimpim.listeners.SignChangeListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public class DimPim extends JavaPlugin {
    /*

    DISCLAIMER
    this is a very, very memeish plugin with no actual value
    this was made for a funny dude who runs a discord
    join it here: https://discord.gg/uvN7aSj
    anyways here's the source you beautiful bastards

     */

    @Override
    public void onEnable() {
        //Call the method to setup Events.\\
        setupEvents();
    }

    private void setupEvents() {
        //Assign the variable "pm" to the Servers Plugin Manager.\\
        PluginManager pm = Bukkit.getServer().getPluginManager();
        //Register all the events necessary\\
        pm.registerEvents(new PlayerChatListener(this), this);
        pm.registerEvents(new SignChangeListener(this), this);
        pm.registerEvents(new ChunkLoadListener(this), this);

    }

    public String randomizeCapitals(String input) {
        Random random = new Random();
        StringBuilder ret = new StringBuilder();
        input.chars().mapToObj(i -> (char) i).forEach(cha -> ret.append(random.nextBoolean() ? Character.toLowerCase(cha) : Character.toLowerCase(cha)));
        return ret.toString();
    }
}