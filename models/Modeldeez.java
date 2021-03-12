public static class Modeldeez extends ModelBase {
	private final ModelRenderer RightLeg;
	private final ModelRenderer Torso;
	private final ModelRenderer RightArm;
	private final ModelRenderer Head;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LeftLeg;

	public Modeldeez() {
		textureWidth = 64;
		textureHeight = 32;

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(0.0F, 21.5F, 0.5F);
		RightLeg.cubeList.add(new ModelBox(RightLeg, 0, 0, 1.0F, -7.5F, -0.5F, 1, 10, 1, 0.0F, false));

		Torso = new ModelRenderer(this);
		Torso.setRotationPoint(4.0F, 14.0F, -3.0F);
		Torso.cubeList.add(new ModelBox(Torso, 0, 0, -6.0F, -12.0F, 2.0F, 4, 12, 3, 0.0F, false));

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(0.0F, 16.0F, 0.5F);
		RightArm.cubeList.add(new ModelBox(RightArm, 0, 0, 2.0F, -14.0F, -0.5F, 1, 9, 1, 0.0F, false));

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 10.0F, 0.5F);
		Head.cubeList.add(new ModelBox(Head, 0, 0, -4.0F, -16.0F, -3.5F, 8, 8, 7, 0.0F, false));

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(-2.5F, 16.0F, 0.5F);
		LeftArm.cubeList.add(new ModelBox(LeftArm, 0, 0, -0.5F, -14.0F, -0.5F, 1, 9, 1, 0.0F, false));

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(0.0F, 21.5F, 0.5F);
		LeftLeg.cubeList.add(new ModelBox(LeftLeg, 0, 0, -2.0F, -7.5F, -0.5F, 1, 10, 1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		RightLeg.render(f5);
		Torso.render(f5);
		RightArm.render(f5);
		Head.render(f5);
		LeftArm.render(f5);
		LeftLeg.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.RightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.LeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.RightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.LeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
	}
}