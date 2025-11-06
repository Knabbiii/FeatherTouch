package dev.knabbiii.feathertouch.listener;

import dev.knabbiii.feathertouch.FeatherTouchPlugin;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Listener that handles damage events caused by feather items.
 * 
 * This listener intercepts damage events where the damager is holding a feather
 * and cancels the damage while preserving the knockback effect.
 * 
 * @author Knabbiii
 * @version 1.0
 * @since 1.0
 */
public class FeatherDamageListener implements Listener {

    private final FeatherTouchPlugin plugin;
    private final Map<UUID, Long> lastFeatherHit = new HashMap<>();
    private static final long FEATHER_COOLDOWN = 600L;

    /**
     * Constructs a new FeatherDamageListener.
     * 
     * @param plugin The main plugin instance
     */
    public FeatherDamageListener(@NotNull FeatherTouchPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Handles entity damage events to modify feather-based attacks.
     * 
     * @param event The EntityDamageByEntityEvent to process
     */
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = false)
    public void onEntityDamageByEntity(@NotNull EntityDamageByEntityEvent event) {
        if (!plugin.isPluginEnabled()) {
            return;
        }
        
        Entity damager = event.getDamager();
        if (!(damager instanceof Player player)) {
            return;
        }
        
        ItemStack itemInHand = player.getInventory().getItemInMainHand();
        if (itemInHand.getType() != Material.FEATHER) {
            return;
        }
        
        // Check cooldown
        UUID playerId = player.getUniqueId();
        long currentTime = System.currentTimeMillis();
        Long lastHit = lastFeatherHit.get(playerId);
        
        if (lastHit != null && (currentTime - lastHit) < FEATHER_COOLDOWN) {
            // Still on cooldown - cancel damage but don't apply effects
            event.setCancelled(true);
            return;
        }
        
        // Update last hit time
        lastFeatherHit.put(playerId, currentTime);
        
        // Cancel the damage
        event.setCancelled(true);
        
        // Apply knockback manually
        Entity victim = event.getEntity();
        Vector direction = victim.getLocation().toVector()
            .subtract(player.getLocation().toVector())
            .normalize()
            .multiply(0.35)
            .setY(0.15);
        
        victim.setVelocity(direction);
        
        // Play sound if enabled
        if (plugin.isSoundEnabled()) {
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 0.5f, 1.5f);
        }
    }

    /**
     * Gets the plugin instance associated with this listener.
     * 
     * @return The FeatherTouchPlugin instance
     */
    @NotNull
    public FeatherTouchPlugin getPlugin() {
        return this.plugin;
    }
}