package me.Novial.LagCheck;

import me.Novial.LagCheck.Events;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new tps(), 100L, 1L);
		getCommand("stats").setExecutor(new Commands());
		getServer().getPluginManager().registerEvents(new Events(), this);
		getServer().getConsoleSender().sendMessage("Enabling LagCheck");
	}
	
	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage("Disabling LagCheck");
	}
}
