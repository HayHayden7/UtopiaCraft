package net.mcreator.utopiacraft.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.utopiacraft.UtopiacraftModElements;
import net.mcreator.utopiacraft.UtopiacraftMod;

import java.util.Map;

@UtopiacraftModElements.ModElement.Tag
public class BunkSwordMobIsHitWithToolProcedure extends UtopiacraftModElements.ModElement {
	public BunkSwordMobIsHitWithToolProcedure(UtopiacraftModElements instance) {
		super(instance, 83);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				UtopiacraftMod.LOGGER.warn("Failed to load dependency entity for procedure BunkSwordMobIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 5, (int) 1, (false), (false)));
	}
}
