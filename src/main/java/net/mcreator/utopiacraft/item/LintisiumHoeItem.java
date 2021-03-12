
package net.mcreator.utopiacraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.HoeItem;

import net.mcreator.utopiacraft.itemgroup.UtopiaCraftToolsTabItemGroup;
import net.mcreator.utopiacraft.UtopiacraftModElements;

@UtopiacraftModElements.ModElement.Tag
public class LintisiumHoeItem extends UtopiacraftModElements.ModElement {
	@ObjectHolder("utopiacraft:lintisiumhoe")
	public static final Item block = null;
	public LintisiumHoeItem(UtopiacraftModElements instance) {
		super(instance, 31);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 1600;
			}

			public float getEfficiency() {
				return 6f;
			}

			public float getAttackDamage() {
				return 1f;
			}

			public int getHarvestLevel() {
				return 0;
			}

			public int getEnchantability() {
				return 15;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(LintisiumIngotItem.block, (int) (1)));
			}
		}, 0, 0f, new Item.Properties().group(UtopiaCraftToolsTabItemGroup.tab)) {
		}.setRegistryName("lintisiumhoe"));
	}
}
