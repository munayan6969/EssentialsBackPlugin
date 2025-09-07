package com.example.backplugin;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDeathEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.util.UUID;

public class PlayerListener implements Listener {

    private final BackPlugin plugin;

    public PlayerListener(BackPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        Location deathLocation = player.getLocation();
        plugin.getLastLocation().put(player.getUniqueId(), deathLocation);
    }

    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent event) {
        Player player = event.getPlayer();
        Location from = event.getFrom();
