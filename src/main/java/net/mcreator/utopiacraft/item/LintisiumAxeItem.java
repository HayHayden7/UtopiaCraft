
package net.mcreator.utopiacraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;
import net.minecraft.entity.LivingEntity;

import net.mcreator.utopiacraft.procedures.LintisiumSwordMobIsHitWithToolProcedure;
import net.mcreator.utopiacraft.itemgroup.UtopiaCraftToolsTabItemGroup;
import net.mcreator.utopiacraft.UtopiacraftModElements;

import java.util.Map;
import java.util.HashMap;

@UtopiacraftModElements.ModElement.Tag
public class LintisiumAxeItem extends UtopiacraftModElements.ModElement {
	@ObjectHolder("utopiacraft:lintisiumaxe")
	public static final Item block = null;
	public LintisiumAxeItem(UtopiacraftModElements instance) {
		super(instance, 30);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 1600;
			}

			public float getEfficiency() {
				return 10f;
			}

			public float getAttackDamage() {
				return 10f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 15;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(LintisiumIngotItem.block, (int) (1)));
			}
		}, 1, -3f, new Item.Properties().group(UtopiaCraftToolsTabItemGroup.tab)) {
			@Override
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					LintisiumSwordMobIsHitWithToolProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("lintisiumaxe"));
	}
}
