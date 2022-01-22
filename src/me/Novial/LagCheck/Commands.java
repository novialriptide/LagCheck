package me.Novial.LagCheck;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_16_R3.CommandExecute;

import java.time.ZoneId;
import java.util.TimeZone;
import java.net.InetAddress;

public class Commands implements CommandExecutor {
	public String prefix = ChatColor.GRAY + "[" + ChatColor.RED + "LagCheck" + ChatColor.GRAY + "] " + ChatColor.RESET;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;

		if (cmd.getName().equals("stats")) {
			Runtime r = Runtime.getRuntime();
			TimeZone timeZone = TimeZone.getDefault();
			String timeZoneStr = timeZone.getDisplayName();
			String systemName = InetAddress.getLocalHost().getHostName();
			if (!player.hasPermission("lagcheck.admin")) {
				timeZoneStr = "[REDACTED]";
				systemName = "[REDACTED]";
			}

			sender.sendMessage(
						 prefix + ChatColor.RED  + "Server Information"
				+ "\n" + ChatColor.GRAY + "Free Memory: " + ChatColor.RED + r.freeMemory() / 1000000 + "MB"
				+ "\n" + ChatColor.GRAY + "Used Memory: " + ChatColor.RED + (r.totalMemory() - r.freeMemory()) / 1000000 + "MB"
				+ "\n" + ChatColor.GRAY + "Total Memory: " + ChatColor.RED + r.totalMemory() / 1000000 + "MB"
				+ "\n" + ChatColor.GRAY + "Max Memory: " + ChatColor.RED + r.maxMemory() / 1000000 + "MB"
				+ "\n" + ChatColor.GRAY + "Available Processors: " + ChatColor.RED + r.availableProcessors() + " cores"
				+ "\n" + ChatColor.GRAY + "TPS: " + ChatColor.RED + Math.round(tps.getTPS() * 100.0) / 100.0
				+ "\n" + ChatColor.GRAY + "Server Timezone: " + ChatColor.RED + timeZoneStr
				+ "\n" + ChatColor.GRAY + "System Name: " + ChatColor.RED + systemName
			);
		}
		
		return true;
	}
}
