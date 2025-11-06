package dev.knabbiii.feathertouch.command;

import dev.knabbiii.feathertouch.FeatherTouchPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

/**
 * Command handler for FeatherTouch plugin commands.
 * 
 * @author Knabbiii
 * @version 1.0
 * @since 1.0
 */
public class FeatherTouchCommand implements CommandExecutor {

    private final FeatherTouchPlugin plugin;

    /**
     * Constructs a new FeatherTouchCommand.
     * 
     * @param plugin The main plugin instance
     */
    public FeatherTouchCommand(@NotNull FeatherTouchPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Handles command execution.
     * 
     * @param sender The command sender
     * @param command The command that was executed
     * @param label The command label
     * @param args The command arguments
     * @return true if the command was handled successfully
     */
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) {
            sender.sendMessage(ChatColor.YELLOW + "FeatherTouch v1.0 - Lightweight feather push plugin");
            sender.sendMessage(ChatColor.GRAY + "Usage: /feathertouch reload");
            return true;
        }

        if (args[0].equalsIgnoreCase("reload")) {
            if (!sender.hasPermission("feathertouch.reload")) {
                sender.sendMessage(ChatColor.RED + "You don't have permission to reload the plugin.");
                return true;
            }

            plugin.reloadPluginConfig();
            sender.sendMessage(ChatColor.GREEN + "FeatherTouch configuration reloaded!");
            return true;
        }

        sender.sendMessage(ChatColor.RED + "Unknown command. Usage: /feathertouch reload");
        return true;
    }
}