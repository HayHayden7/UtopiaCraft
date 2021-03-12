public static class Modelimpossiblefishv2 extends ModelBase {
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
		LeftArm.cubeList.add(new ModelBox(LeftArm, 0, 16, -1.0F, 0.0F, -1.0F, 2, 12, 2, 0.0F, false));
		LeftArm.cubeList.add(new ModelBox(LeftArm, 0, 26, 0.0F, 12.0F, -1.0F, 1, 2, 2, 0.0F, false));
		LeftArm.cubeList.add(new ModelBox(LeftArm, 0, 28, 0.0F, 12.0F, -2.0F, 1, 1, 1, 0.0F, false));

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(5.0F, 3.0F, 0.0F);
		RightArm.cubeList.add(new ModelBox(RightArm, 0, 16, -1.0F, 0.0F, -1.0F, 2, 12, 2, 0.0F, false));
		RightArm.cubeList.add(new ModelBox(RightArm, 0, 25, -1.0F, 12.0F, -1.0F, 1, 2, 2, 0.0F, false));
		RightArm.cubeList.add(new ModelBox(RightArm, 0, 28, -1.0F, 12.0F, -2.0F, 1, 1, 1, 0.0F, false));

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(1.25F, 8.0F, -2.0F);
		LeftLeg.cubeList.add(new ModelBox(LeftLeg, 8, 16, -4.25F, 0.0F, 1.0F, 2, 16, 2, 0.0F, false));
		LeftLeg.cubeList.add(new ModelBox(LeftLeg, 0, 18, -4.25F, 15.0F, -1.0F, 2, 1, 2, 0.0F, false));

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(1.25F, 8.0F, 2.0F);
		RightLeg.cubeList.add(new ModelBox(RightLeg, 8, 16, -0.25F, 0.0F, -3.0F, 2, 16, 2, 0.0F, false));
		RightLeg.cubeList.add(new ModelBox(RightLeg, 0, 27, -0.25F, 15.0F, -5.0F, 2, 1, 2, 0.0F, false));

		Tank = new ModelRenderer(this);
		Tank.setRotationPoint(0.0F, 4.0F, 0.0F);
		Tank.cubeList.add(new ModelBox(Tank, 0, 0, -4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F, false));

		Fish = new ModelRenderer(this);
		Fish.setRotationPoint(0.0F, 0.0F, 0.0F);
		Tank.addChild(Fish);
		Fish.cubeList.add(new ModelBox(Fish, 16, 16, -1.0F, -1.0F, -2.0F, 2, 2, 4, 0.0F, false));
		Fish.cubeList.add(new ModelBox(Fish, 16, 16, -2.0F, 0.0F, -1.0F, 1, 0, 2, 0.0F, false));
		Fish.cubeList.add(new ModelBox(Fish, 16, 16, 1.0F, 0.0F, -1.0F, 1, 0, 2, 0.0F, false));
		Fish.cubeList.add(new ModelBox(Fish, 16, 16, 0.0F, -1.0F, 2.0F, 0, 2, 1, 0.0F, false));

		Water = new ModelRenderer(this);
		Water.setRotationPoint(0.0F, 0.0F, 0.0F);
		Tank.addChild(Water);
		Water.cubeList.add(new ModelBox(Water, 0, 34, -3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		LeftArm.render(f5);
		RightArm.render(f5);
		LeftLeg.render(f5);
		RightLeg.render(f5);
		Tank.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
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