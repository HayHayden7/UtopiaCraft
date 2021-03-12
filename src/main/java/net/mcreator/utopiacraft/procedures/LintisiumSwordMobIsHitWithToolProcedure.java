package net.mcreator.utopiacraft.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.utopiacraft.UtopiacraftModElements;
import net.mcreator.utopiacraft.UtopiacraftMod;

import java.util.Map;

@UtopiacraftModElements.ModElement.Tag
public class LintisiumSwordMobIsHitWithToolProcedure extends UtopiacraftModElements.ModElement {
	public LintisiumSwordMobIsHitWithToolProcedure(UtopiacraftModElements instance) {
		super(instance, 28);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				UtopiacraftMod.LOGGER.warn("Failed to load dependency entity for procedure LintisiumSwordMobIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setFire((int) 5);
	}
}
