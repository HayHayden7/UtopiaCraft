
package net.mcreator.utopiacraft.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.utopiacraft.block.RyderLogBlock;
import net.mcreator.utopiacraft.UtopiacraftModElements;

@UtopiacraftModElements.ModElement.Tag
public class FuelRyderLogFuel extends UtopiacraftModElements.ModElement {
	public FuelRyderLogFuel(UtopiacraftModElements instance) {
		super(instance, 23);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(RyderLogBlock.block, (int) (1)).getItem())
			event.setBurnTime(300);
	}
}
