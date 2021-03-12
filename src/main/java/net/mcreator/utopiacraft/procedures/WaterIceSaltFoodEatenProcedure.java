package net.mcreator.utopiacraft.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;

import net.mcreator.utopiacraft.UtopiacraftModElements;
import net.mcreator.utopiacraft.UtopiacraftMod;

import java.util.Map;

@UtopiacraftModElements.ModElement.Tag
public class WaterIceSaltFoodEatenProcedure extends UtopiacraftModElements.ModElement {
	public WaterIceSaltFoodEatenProcedure(UtopiacraftModElements instance) {
		super(instance, 75);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				UtopiacraftMod.LOGGER.warn("Failed to load dependency x for procedure WaterIceSaltFoodEaten!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				UtopiacraftMod.LOGGER.warn("Failed to load dependency y for procedure WaterIceSaltFoodEaten!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				UtopiacraftMod.LOGGER.warn("Failed to load dependency z for procedure WaterIceSaltFoodEaten!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				UtopiacraftMod.LOGGER.warn("Failed to load dependency world for procedure WaterIceSaltFoodEaten!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof World && !world.isRemote()) {
			((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("utopiacraft:watericesalyaye")),
					SoundCategory.NEUTRAL, (float) 1, (float) 1);
		} else {
			((World) world).playSound(x, y, z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("utopiacraft:watericesalyaye")),
					SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
		}
	}
}
