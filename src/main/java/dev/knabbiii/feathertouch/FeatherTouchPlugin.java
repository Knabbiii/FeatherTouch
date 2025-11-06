package dev.knabbiii.feathertouch;

import dev.knabbiii.feathertouch.command.FeatherTouchCommand;
import dev.knabbiii.feathertouch.listener.FeatherDamageListener;
import dev.knabbiii.feathertouch.libs.bstats.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * FeatherTouch Plugin
 * 
 * A lightweight Minecraft plugin that makes hitting with a feather remove damage but keep knockback.
 * 
 * @author Knabbiii
 * @version 1.0
 * @since 1.0
 */
public final class FeatherTouchPlugin extends JavaPlugin {

    private FeatherDamageListener damageListener;
    private FeatherTouchCommand featherTouchCommand;
    private boolean pluginEnabled = true;
    private boolean soundEnabled = true;

    /**
     * Called when the plugin is enabled.
     */
    @Override
    public void onEnable() {
        getLogger().info("FeatherTouch is starting up...");
        
        // Save default config
        saveDefaultConfig();
        
        // Load config settings
        loadConfigSettings();
        
        // Initialize and register the damage listener
        this.damageListener = new FeatherDamageListener(this);
        getServer().getPluginManager().registerEvents(this.damageListener, this);
        
        // Initialize and register commands
        this.featherTouchCommand = new FeatherTouchCommand(this);
        getCommand("feathertouch").setExecutor(this.featherTouchCommand);
        
        // Initialize bStats if metrics are enabled
        if (getConfig().getBoolean("metrics", true)) {
            new Metrics(this, 27875);
            getLogger().info("Metrics enabled (bStats)");
        }
        
        getLogger().info("FeatherTouch has been enabled!");
    }

    /**
     * Called when the plugin is disabled.
     */
    @Override
    public void onDisable() {
        getLogger().info("FeatherTouch has been disabled.");
        
        // Clean up references
        this.damageListener = null;
        this.featherTouchCommand = null;
    }

    /**
     * Reloads the plugin configuration.
     */
    public void reloadPluginConfig() {
        reloadConfig();
        loadConfigSettings();
        getLogger().info("Configuration reloaded!");
    }

    /**
     * Loads configuration settings from config.yml.
     */
    private void loadConfigSettings() {
        this.pluginEnabled = getConfig().getBoolean("settings.enabled", true);
        this.soundEnabled = getConfig().getBoolean("settings.sound", true);
    }

    /**
     * Checks if the plugin functionality is enabled.
     * 
     * @return true if enabled, false otherwise
     */
    public boolean isPluginEnabled() {
        return this.pluginEnabled;
    }

    /**
     * Checks if sound effects are enabled.
     * 
     * @return true if sounds are enabled, false otherwise
     */
    public boolean isSoundEnabled() {
        return this.soundEnabled;
    }

    /**
     * Gets the damage listener instance.
     * 
     * @return The FeatherDamageListener instance
     */
    public FeatherDamageListener getDamageListener() {
        return this.damageListener;
    }
}