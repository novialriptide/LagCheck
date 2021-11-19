package me.Novial.LagCheck;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.md_5.bungee.api.ChatColor;

public class Events implements Listener {
	@EventHandler
	public static void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		player.sendMessage(ChatColor.GRAY + "This server uses " + ChatColor.RED + "LagChecker" + ChatColor.GRAY + ", developed by Novial.");
	}
}
