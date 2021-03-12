
package net.mcreator.utopiacraft.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.utopiacraft.block.RyderLogBlock;
import net.mcreator.utopiacraft.UtopiacraftModElements;

@UtopiacraftModElements.ModElement.Tag
public class UtopiaCraftBlocksTabItemGroup extends UtopiacraftModElements.ModElement {
	public UtopiaCraftBlocksTabItemGroup(UtopiacraftModElements instance) {
		super(instance, 219);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabutopia_craft_blocks_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(RyderLogBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
