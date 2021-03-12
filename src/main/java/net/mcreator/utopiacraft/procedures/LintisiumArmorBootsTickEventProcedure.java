package net.mcreator.utopiacraft.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.utopiacraft.UtopiacraftModElements;
import net.mcreator.utopiacraft.UtopiacraftMod;

import java.util.Map;

@UtopiacraftModElements.ModElement.Tag
public class LintisiumArmorBootsTickEventProcedure extends UtopiacraftModElements.ModElement {
	public LintisiumArmorBootsTickEventProcedure(UtopiacraftModElements instance) {
		super(instance, 27);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				UtopiacraftMod.LOGGER.warn("Failed to load dependency entity for procedure LintisiumArmorBootsTickEvent!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				UtopiacraftMod.LOGGER.warn("Failed to load dependency x for procedure LintisiumArmorBootsTickEvent!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				UtopiacraftMod.LOGGER.warn("Failed to load dependency y for procedure LintisiumArmorBootsTickEvent!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				UtopiacraftMod.LOGGER.warn("Failed to load dependency z for procedure LintisiumArmorBootsTickEvent!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				UtopiacraftMod.LOGGER.warn("Failed to load dependency world for procedure LintisiumArmorBootsTickEvent!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.LAVA.getDefaultState().getBlock())) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, (int) 30, (int) 1, (false), (false)));
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.LAVA.getDefaultState().getBlock())) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, (int) 30, (int) 1, (false), (false)));
		}
	}
}
