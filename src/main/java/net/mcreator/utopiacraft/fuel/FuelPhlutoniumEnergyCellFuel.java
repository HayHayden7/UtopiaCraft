
package net.mcreator.utopiacraft.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.utopiacraft.item.PhlutoniumEnergyCellItem;
import net.mcreator.utopiacraft.UtopiacraftModElements;

@UtopiacraftModElements.ModElement.Tag
public class FuelPhlutoniumEnergyCellFuel extends UtopiacraftModElements.ModElement {
	public FuelPhlutoniumEnergyCellFuel(UtopiacraftModElements instance) {
		super(instance, 100);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(PhlutoniumEnergyCellItem.block, (int) (1)).getItem())
			event.setBurnTime(30000);
	}
}
