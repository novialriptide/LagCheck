package me.Novial.LagCheck;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Commands implements CommandExecutor {
	public String prefix = ChatColor.GRAY + "[" + ChatColor.WHITE + "LagCheck" + ChatColor.GRAY + "] " + ChatColor.RESET;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equals("stats")) {
			Runtime r = Runtime.getRuntime();
			
			double usedMemory = (r.totalMemory() - r.freeMemory()) / 1000000;
			ChatColor usedMemoryColor = ChatColor.GREEN;
			
			double freeMemory = r.freeMemory() / 1000000;
			ChatColor freeMemoryColor = ChatColor.GREEN;
			
			double totalMemory = r.totalMemory() / 1000000;
			double maxMemory = r.maxMemory() / 1000000;
			
			double tpsValue = Math.round(tps.getTPS() * 100.0) / 100.0;
			ChatColor tpsColor = ChatColor.GREEN;
			
			if (usedMemory / totalMemory > 0.5) {
				usedMemoryColor = ChatColor.YELLOW;
				freeMemoryColor = ChatColor.YELLOW;
			}
			else if (usedMemory / totalMemory > 0.8) {
				usedMemoryColor = ChatColor.RED;
				freeMemoryColor = ChatColor.RED;
			}
			
			if (tpsValue / 20 < 0.8) {
				tpsColor = ChatColor.YELLOW;
			}
			else if (tpsValue / 20 < 0.5) {
				tpsColor = ChatColor.RED;
			}

			sender.sendMessage(
						 prefix + ChatColor.WHITE  + "Server Information"
				+ "\n" + ChatColor.GRAY + "Used Memory: " + usedMemoryColor + usedMemory + "MB"
				+ "\n" + ChatColor.GRAY + "Free Memory: " + freeMemoryColor + freeMemory + "MB"
				+ "\n" + ChatColor.GRAY + "Total Memory: " + ChatColor.WHITE + totalMemory + "MB"
				+ "\n" + ChatColor.GRAY + "Max Memory: " + ChatColor.WHITE + maxMemory + "MB"
				+ "\n" + ChatColor.GRAY + "Available Processors: " + ChatColor.WHITE + r.availableProcessors() + " cores"
				+ "\n" + ChatColor.GRAY + "TPS: " + tpsColor + tpsValue
			);
		}
		
		return true;
	}
}
