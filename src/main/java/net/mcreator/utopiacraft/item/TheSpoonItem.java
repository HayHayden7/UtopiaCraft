
package net.mcreator.utopiacraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.utopiacraft.itemgroup.UtopiaCraftToolsTabItemGroup;
import net.mcreator.utopiacraft.UtopiacraftModElements;

@UtopiacraftModElements.ModElement.Tag
public class TheSpoonItem extends UtopiacraftModElements.ModElement {
	@ObjectHolder("utopiacraft:thespoon")
	public static final Item block = null;
	public TheSpoonItem(UtopiacraftModElements instance) {
		super(instance, 148);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 3000;
			}

			public float getEfficiency() {
				return 14f;
			}

			public float getAttackDamage() {
				return 4f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 12;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -3f, new Item.Properties().group(UtopiaCraftToolsTabItemGroup.tab)) {
		}.setRegistryName("thespoon"));
	}
}
