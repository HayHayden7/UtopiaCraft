
package net.mcreator.utopiacraft.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.block.material.Material;

import net.mcreator.utopiacraft.itemgroup.UtopiaCraftItemsTabItemGroup;
import net.mcreator.utopiacraft.item.ImpossibleFishFoodItem;
import net.mcreator.utopiacraft.UtopiacraftModElements;

import java.util.Random;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@UtopiacraftModElements.ModElement.Tag
public class ImpossibleFishEntity extends UtopiacraftModElements.ModElement {
	public static EntityType entity = null;
	public ImpossibleFishEntity(UtopiacraftModElements instance) {
		super(instance, 162);
		FMLJavaModLoadingContext.get().getModEventBus().register(new ModelRegisterHandler());
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.CREATURE).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire().size(0.6f, 1.2f))
						.build("impossiblefish").setRegistryName("impossiblefish");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -16750849, -52429, new Item.Properties().group(UtopiaCraftItemsTabItemGroup.tab))
				.setRegistryName("impossiblefish_spawn_egg"));
	}

	@SubscribeEvent
	public void addFeatureToBiomes(BiomeLoadingEvent event) {
		boolean biomeCriteria = false;
		if (new ResourceLocation("utopiacraft:utopianplains").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("utopiacraft:utopian_forest").equals(event.getName()))
			biomeCriteria = true;
		if (new ResourceLocation("utopiacraft:heavenly_forest").equals(event.getName()))
			biomeCriteria = true;
		if (!biomeCriteria)
			return;
		event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(entity, 10, 1, 1));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		DeferredWorkQueue.runLater(this::setupAttributes);
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos,
						random) -> (world.getBlockState(pos.down()).getMaterial() == Material.ORGANIC && world.getLightSubtracted(pos, 0) > 8));
	}
	private static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelimpossiblefishv2(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("utopiacraft:textures/impossiblefish6v2.png");
					}
				};
			});
		}
	}
	private void setupAttributes() {
		AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
		ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3);
		ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 10);
		ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
		ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 3);
		GlobalEntityTypeAttributes.put(entity, ammma.create());
	}
	public static class CustomEntity extends CreatureEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 5;
			setNoAI(false);
			enablePersistence();
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 1));
			this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(3, new SwimGoal(this));
			this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, (float) 0.8));
			this.goalSelector.addGoal(5, new PanicGoal(this, 1.2));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
			this.entityDropItem(new ItemStack(ImpossibleFishFoodItem.block, (int) (1)));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.hurt_drown"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash"));
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.DROWN)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		public void livingTick() {
			super.livingTick();
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Random random = this.rand;
			Entity entity = this;
			if (true)
				for (int l = 0; l < 2; ++l) {
					double d0 = (double) ((float) x + 0.5) + (double) (random.nextFloat() - 0.5) * 0.5D;
					double d1 = ((double) ((float) y + 0.7) + (double) (random.nextFloat() - 0.5) * 0.5D) + 0.5;
					double d2 = (double) ((float) z + 0.5) + (double) (random.nextFloat() - 0.5) * 0.5D;
					world.addParticle(ParticleTypes.FALLING_WATER, d0, d1, d2, 0, 0, 0);
				}
		}
	}

	public static class Modelimpossiblefishv2 extends EntityModel<Entity> {
		private final ModelRenderer LeftArm;
		private final ModelRenderer RightArm;
		private final ModelRenderer LeftLeg;
		private final ModelRenderer RightLeg;
		private final ModelRenderer Tank;
		private final ModelRenderer Fish;
		private final ModelRenderer Water;
		public Modelimpossiblefishv2() {
			textureWidth = 64;
			textureHeight = 64;
			LeftArm = new ModelRenderer(this);
			LeftArm.setRotationPoint(-5.0F, 3.0F, 0.0F);
			addBoxHelper(LeftArm, 0, 16, -1.0F, 0.0F, -1.0F, 2, 12, 2, 0.0F, false);
			addBoxHelper(LeftArm, 0, 26, 0.0F, 12.0F, -1.0F, 1, 2, 2, 0.0F, false);
			addBoxHelper(LeftArm, 0, 28, 0.0F, 12.0F, -2.0F, 1, 1, 1, 0.0F, false);
			RightArm = new ModelRenderer(this);
			RightArm.setRotationPoint(5.0F, 3.0F, 0.0F);
			addBoxHelper(RightArm, 0, 16, -1.0F, 0.0F, -1.0F, 2, 12, 2, 0.0F, false);
			addBoxHelper(RightArm, 0, 25, -1.0F, 12.0F, -1.0F, 1, 2, 2, 0.0F, false);
			addBoxHelper(RightArm, 0, 28, -1.0F, 12.0F, -2.0F, 1, 1, 1, 0.0F, false);
			LeftLeg = new ModelRenderer(this);
			LeftLeg.setRotationPoint(1.25F, 8.0F, -2.0F);
			addBoxHelper(LeftLeg, 8, 16, -4.25F, 0.0F, 1.0F, 2, 16, 2, 0.0F, false);
			addBoxHelper(LeftLeg, 0, 18, -4.25F, 15.0F, -1.0F, 2, 1, 2, 0.0F, false);
			RightLeg = new ModelRenderer(this);
			RightLeg.setRotationPoint(1.25F, 8.0F, 2.0F);
			addBoxHelper(RightLeg, 8, 16, -0.25F, 0.0F, -3.0F, 2, 16, 2, 0.0F, false);
			addBoxHelper(RightLeg, 0, 27, -0.25F, 15.0F, -5.0F, 2, 1, 2, 0.0F, false);
			Tank = new ModelRenderer(this);
			Tank.setRotationPoint(0.0F, 4.0F, 0.0F);
			addBoxHelper(Tank, 0, 0, -4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F, false);
			Fish = new ModelRenderer(this);
			Fish.setRotationPoint(0.0F, 0.0F, 0.0F);
			Tank.addChild(Fish);
			addBoxHelper(Fish, 16, 16, -1.0F, -1.0F, -2.0F, 2, 2, 4, 0.0F, false);
			addBoxHelper(Fish, 16, 16, -2.0F, 0.0F, -1.0F, 1, 0, 2, 0.0F, false);
			addBoxHelper(Fish, 16, 16, 1.0F, 0.0F, -1.0F, 1, 0, 2, 0.0F, false);
			addBoxHelper(Fish, 16, 16, 0.0F, -1.0F, 2.0F, 0, 2, 1, 0.0F, false);
			Water = new ModelRenderer(this);
			Water.setRotationPoint(0.0F, 0.0F, 0.0F);
			Tank.addChild(Water);
			addBoxHelper(Water, 0, 34, -3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F, false);
		}

		@Override
		public void render(MatrixStack ms, IVertexBuilder vb, int i1, int i2, float f1, float f2, float f3, float f4) {
			LeftArm.render(ms, vb, i1, i2, f1, f2, f3, f4);
			RightArm.render(ms, vb, i1, i2, f1, f2, f3, f4);
			LeftLeg.render(ms, vb, i1, i2, f1, f2, f3, f4);
			RightLeg.render(ms, vb, i1, i2, f1, f2, f3, f4);
			Tank.render(ms, vb, i1, i2, f1, f2, f3, f4);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.Water.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Water.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.RightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.LeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.LeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.RightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.Fish.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Fish.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.Tank.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Tank.rotateAngleX = f4 / (180F / (float) Math.PI);
		}
	}
	@OnlyIn(Dist.CLIENT)
	public static void addBoxHelper(ModelRenderer renderer, int texU, int texV, float x, float y, float z, int dx, int dy, int dz, float delta) {
		addBoxHelper(renderer, texU, texV, x, y, z, dx, dy, dz, delta, renderer.mirror);
	}

	@OnlyIn(Dist.CLIENT)
	public static void addBoxHelper(ModelRenderer renderer, int texU, int texV, float x, float y, float z, int dx, int dy, int dz, float delta,
			boolean mirror) {
		renderer.mirror = mirror;
		renderer.addBox("", x, y, z, dx, dy, dz, delta, texU, texV);
	}
}
