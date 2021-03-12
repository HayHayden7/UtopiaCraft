
package net.mcreator.utopiacraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;

import net.mcreator.utopiacraft.procedures.RoastedDeezianNutItemIsCraftedProcedure;
import net.mcreator.utopiacraft.procedures.RoastedDeezianNutFoodEatenProcedure;
import net.mcreator.utopiacraft.itemgroup.UtopiaCraftItemsTabItemGroup;
import net.mcreator.utopiacraft.UtopiacraftModElements;

import java.util.Map;
import java.util.HashMap;

@UtopiacraftModElements.ModElement.Tag
public class RoastedDeezianNutItem extends UtopiacraftModElements.ModElement {
	@ObjectHolder("utopiacraft:roasteddeeziannut")
	public static final Item block = null;
	public RoastedDeezianNutItem(UtopiacraftModElements instance) {
		super(instance, 78);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(UtopiaCraftItemsTabItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(4).saturation(0.3f).build()));
			setRegistryName("roasteddeeziannut");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				RoastedDeezianNutFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}

		@Override
		public void onCreated(ItemStack itemstack, World world, PlayerEntity entity) {
			super.onCreated(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				RoastedDeezianNutItemIsCraftedProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
