
package net.mcreator.utopiacraft.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.Entity;

import net.mcreator.utopiacraft.itemgroup.UtopiaCraftToolsTabItemGroup;
import net.mcreator.utopiacraft.UtopiacraftModElements;

@UtopiacraftModElements.ModElement.Tag
public class LintisiumArmorItem extends UtopiacraftModElements.ModElement {
	@ObjectHolder("utopiacraft:lintisiumarmor_helmet")
	public static final Item helmet = null;
	@ObjectHolder("utopiacraft:lintisiumarmor_chestplate")
	public static final Item body = null;
	@ObjectHolder("utopiacraft:lintisiumarmor_leggings")
	public static final Item legs = null;
	@ObjectHolder("utopiacraft:lintisiumarmor_boots")
	public static final Item boots = null;
	public LintisiumArmorItem(UtopiacraftModElements instance) {
		super(instance, 26);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			@Override
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 36;
			}

			@Override
			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{4, 7, 9, 4}[slot.getIndex()];
			}

			@Override
			public int getEnchantability() {
				return 15;
			}

			@Override
			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_iron"));
			}

			@Override
			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(LintisiumIngotItem.block, (int) (1)));
			}

			@OnlyIn(Dist.CLIENT)
			@Override
			public String getName() {
				return "lintisiumarmor";
			}

			@Override
			public float getToughness() {
				return 2f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(UtopiaCraftToolsTabItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "utopiacraft:textures/models/armor/lintisium__updated_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("lintisiumarmor_helmet"));
		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(UtopiaCraftToolsTabItemGroup.tab)) {
					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "utopiacraft:textures/models/armor/lintisium__updated_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
					}
				}.setRegistryName("lintisiumarmor_chestplate"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(UtopiaCraftToolsTabItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "utopiacraft:textures/models/armor/lintisium__updated_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("lintisiumarmor_leggings"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(UtopiaCraftToolsTabItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "utopiacraft:textures/models/armor/lintisium__updated_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("lintisiumarmor_boots"));
	}
}
