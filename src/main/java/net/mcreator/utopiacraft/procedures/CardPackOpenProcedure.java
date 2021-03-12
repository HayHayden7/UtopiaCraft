package net.mcreator.utopiacraft.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.utopiacraft.item.WaifuCard9Item;
import net.mcreator.utopiacraft.item.WaifuCard8Item;
import net.mcreator.utopiacraft.item.WaifuCard7Item;
import net.mcreator.utopiacraft.item.WaifuCard6Item;
import net.mcreator.utopiacraft.item.WaifuCard5Item;
import net.mcreator.utopiacraft.item.WaifuCard4Item;
import net.mcreator.utopiacraft.item.WaifuCard3Item;
import net.mcreator.utopiacraft.item.WaifuCard2Item;
import net.mcreator.utopiacraft.item.WaifuCard1Item;
import net.mcreator.utopiacraft.item.CardPackItem;
import net.mcreator.utopiacraft.UtopiacraftModElements;
import net.mcreator.utopiacraft.UtopiacraftMod;

import java.util.Map;

@UtopiacraftModElements.ModElement.Tag
public class CardPackOpenProcedure extends UtopiacraftModElements.ModElement {
	public CardPackOpenProcedure(UtopiacraftModElements instance) {
		super(instance, 151);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				UtopiacraftMod.LOGGER.warn("Failed to load dependency entity for procedure CardPackOpen!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity) {
			ItemStack _stktoremove = new ItemStack(CardPackItem.block, (int) (1));
			((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
					((PlayerEntity) entity).container.func_234641_j_());
		}
		if ((Math.random() <= 0.111)) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(WaifuCard1Item.block, (int) (1));
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		}
		if (((Math.random() > 0.111) && (Math.random() <= 0.222))) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(WaifuCard2Item.block, (int) (1));
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		}
		if (((Math.random() > 0.222) && (Math.random() <= 0.333))) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(WaifuCard3Item.block, (int) (1));
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		}
		if (((Math.random() > 0.333) && (Math.random() <= 0.444))) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(WaifuCard4Item.block, (int) (1));
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		}
		if (((Math.random() > 0.444) && (Math.random() <= 0.555))) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(WaifuCard5Item.block, (int) (1));
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		}
		if (((Math.random() > 0.555) && (Math.random() <= 0.666))) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(WaifuCard6Item.block, (int) (1));
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		}
		if (((Math.random() > 0.666) && (Math.random() <= 0.777))) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(WaifuCard7Item.block, (int) (1));
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		}
		if (((Math.random() > 0.777) && (Math.random() <= 0.888))) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(WaifuCard8Item.block, (int) (1));
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		}
		if (((Math.random() > 0.888) && (Math.random() <= 0.999))) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(WaifuCard9Item.block, (int) (1));
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		}
	}
}
