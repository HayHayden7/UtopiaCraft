
package net.mcreator.utopiacraft.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.utopiacraft.item.CrekChunkItem;
import net.mcreator.utopiacraft.UtopiacraftModElements;

@UtopiacraftModElements.ModElement.Tag
public class UtopiaCraftItemsTabItemGroup extends UtopiacraftModElements.ModElement {
	public UtopiaCraftItemsTabItemGroup(UtopiacraftModElements instance) {
		super(instance, 220);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabutopia_craft_items_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(CrekChunkItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
