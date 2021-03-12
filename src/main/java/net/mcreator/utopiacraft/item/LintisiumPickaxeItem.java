
package net.mcreator.utopiacraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.utopiacraft.itemgroup.UtopiaCraftToolsTabItemGroup;
import net.mcreator.utopiacraft.UtopiacraftModElements;

@UtopiacraftModElements.ModElement.Tag
public class LintisiumPickaxeItem extends UtopiacraftModElements.ModElement {
	@ObjectHolder("utopiacraft:lintisiumpickaxe")
	public static final Item block = null;
	public LintisiumPickaxeItem(UtopiacraftModElements instance) {
		super(instance, 29);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 1600;
			}

			public float getEfficiency() {
				return 9f;
			}

			public float getAttackDamage() {
				return 6f;
			}

			public int getHarvestLevel() {
				return 3;
			}

			public int getEnchantability() {
				return 15;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(LintisiumIngotItem.block, (int) (1)));
			}
		}, 1, -2.8f, new Item.Properties().group(UtopiaCraftToolsTabItemGroup.tab)) {
		}.setRegistryName("lintisiumpickaxe"));
	}
}
