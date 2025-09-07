package com.example.backplugin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public class BackPlugin extends JavaPlugin {

    private final HashMap<UUID, Location> lastLocations = new HashMap<>();

    @Override
    public void onEnable() {
        getLogger().info("BackPlugin has been enabled!");
        getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        getLogger().info("BackPlugin has been disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command!");
            return true;
        }

        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("back")) {
            if (lastLocations.containsKey(player.getUniqueId()))
