package dev.knabbiii.feathertouch;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * FeatherTouch Fabric Mod
 * 
 * A lightweight Minecraft mod that makes hitting with a feather remove damage but keep knockback.
 * Works in singleplayer and multiplayer. Optional on client when installed on server.
 * 
 * @author Knabbiii
 * @version 1.1
 */
public class FeatherTouch implements ModInitializer {
	public static final String MOD_ID = "feathertouch";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	
	private static final long COOLDOWN_MS = 600;
	private static final double KNOCKBACK_HORIZONTAL = 0.35;
	private static final double KNOCKBACK_VERTICAL = 0.15;
	
	private final Map<UUID, Long> lastHitTime = new HashMap<>();

	@Override
	public void onInitialize() {
		LOGGER.info("FeatherTouch is starting up...");
		
		AttackEntityCallback.EVENT.register(this::onAttackEntity);
		
		LOGGER.info("FeatherTouch has been enabled!");
	}
	
	private ActionResult onAttackEntity(PlayerEntity player, World world, Hand hand, Entity entity, EntityHitResult hitResult) {
		if (world.isClient || !(player instanceof ServerPlayerEntity serverPlayer)) {
			return ActionResult.PASS;
		}
		
		if (!serverPlayer.getStackInHand(hand).isOf(Items.FEATHER)) {
			return ActionResult.PASS;
		}
		
		UUID playerId = serverPlayer.getUuid();
		long currentTime = System.currentTimeMillis();
		long lastHit = lastHitTime.getOrDefault(playerId, 0L);
		
		if (currentTime - lastHit < COOLDOWN_MS) {
			return ActionResult.FAIL;
		}
		
		lastHitTime.put(playerId, currentTime);
		
		Vec3d playerPos = serverPlayer.getPos();
		Vec3d entityPos = entity.getPos();
		Vec3d direction = entityPos.subtract(playerPos).normalize();
		
		Vec3d knockback = new Vec3d(
			direction.x * KNOCKBACK_HORIZONTAL,
			KNOCKBACK_VERTICAL,
			direction.z * KNOCKBACK_HORIZONTAL
		);
		
		entity.setVelocity(knockback);
		entity.velocityModified = true;
		
		world.playSound(
			null,
			entity.getX(),
			entity.getY(),
			entity.getZ(),
			SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP,
			SoundCategory.PLAYERS,
			1.0F,
			1.0F
		);
		
		return ActionResult.FAIL;
	}
}
