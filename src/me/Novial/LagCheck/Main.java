package me.Novial.LagCheck;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new tps(), 100L, 1L);
		getCommand("stats").setExecutor(new Commands());
		getServer().getConsoleSender().sendMessage("Enabling LagCheck");
	}
	
	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage("Disabling LagCheck");
	}
}
