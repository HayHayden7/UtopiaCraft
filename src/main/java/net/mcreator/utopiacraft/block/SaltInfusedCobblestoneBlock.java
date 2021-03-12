
package net.mcreator.utopiacraft.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.utopiacraft.itemgroup.UtopiaCraftBlocksTabItemGroup;
import net.mcreator.utopiacraft.UtopiacraftModElements;

import java.util.List;
import java.util.Collections;

@UtopiacraftModElements.ModElement.Tag
public class SaltInfusedCobblestoneBlock extends UtopiacraftModElements.ModElement {
	@ObjectHolder("utopiacraft:saltinfusedcobblestone")
	public static final Block block = null;
	public SaltInfusedCobblestoneBlock(UtopiacraftModElements instance) {
		super(instance, 87);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(
				() -> new BlockItem(block, new Item.Properties().group(UtopiaCraftBlocksTabItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(2f, 30f).setLightLevel(s -> 7));
			setRegistryName("saltinfusedcobblestone");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
