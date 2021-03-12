
package net.mcreator.utopiacraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.utopiacraft.itemgroup.UtopiaCraftItemsTabItemGroup;
import net.mcreator.utopiacraft.UtopiacraftModElements;

@UtopiacraftModElements.ModElement.Tag
public class BunkRodItem extends UtopiacraftModElements.ModElement {
	@ObjectHolder("utopiacraft:bunkrod")
	public static final Item block = null;
	public BunkRodItem(UtopiacraftModElements instance) {
		super(instance, 102);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(UtopiaCraftItemsTabItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("bunkrod");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
