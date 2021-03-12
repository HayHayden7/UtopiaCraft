
package net.mcreator.utopiacraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

import net.mcreator.utopiacraft.itemgroup.UtopiaCraftItemsTabItemGroup;
import net.mcreator.utopiacraft.UtopiacraftModElements;

@UtopiacraftModElements.ModElement.Tag
public class CookedImpossibleFishItem extends UtopiacraftModElements.ModElement {
	@ObjectHolder("utopiacraft:cooked_impossible_fish")
	public static final Item block = null;
	public CookedImpossibleFishItem(UtopiacraftModElements instance) {
		super(instance, 194);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(UtopiaCraftItemsTabItemGroup.tab).maxStackSize(64).rarity(Rarity.EPIC)
					.food((new Food.Builder()).hunger(10).saturation(1.2f).build()));
			setRegistryName("cooked_impossible_fish");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}
	}
}
