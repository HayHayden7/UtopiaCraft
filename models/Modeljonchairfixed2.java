public static class Modeljonchairfixed2 extends ModelBase {
	private final ModelRenderer seat;
	private final ModelRenderer base;

	public Modeljonchairfixed2() {
		textureWidth = 16;
		textureHeight = 16;

		seat = new ModelRenderer(this);
		seat.setRotationPoint(0.0F, 18.6F, 0.6667F);
		seat.cubeList.add(new ModelBox(seat, 0, 0, -5.0F, -2.6F, -5.6667F, 10, 1, 10, 0.0F, false));
		seat.cubeList.add(new ModelBox(seat, 0, 0, -0.5F, -8.6F, 4.3333F, 1, 7, 1, 0.0F, false));
		seat.cubeList.add(new ModelBox(seat, 0, 0, -4.0F, -10.6F, 3.3333F, 8, 4, 1, 0.0F, false));
		seat.cubeList.add(new ModelBox(seat, 0, 0, 5.0F, -4.6F, -1.1667F, 1, 3, 1, 0.0F, false));
		seat.cubeList.add(new ModelBox(seat, 0, 0, -6.0F, -4.6F, -1.1667F, 1, 3, 1, 0.0F, false));
		seat.cubeList.add(new ModelBox(seat, 0, 0, 5.0F, -5.6F, -2.6667F, 1, 1, 4, 0.0F, false));
		seat.cubeList.add(new ModelBox(seat, 0, 0, -6.0F, -5.6F, -2.6667F, 1, 1, 4, 0.0F, false));

		base = new ModelRenderer(this);
		base.setRotationPoint(6.0F, 23.5F, 0.5F);
		base.cubeList.add(new ModelBox(base, 0, 0, -12.0F, -1.5F, -1.0F, 12, 1, 1, 0.0F, false));
		base.cubeList.add(new ModelBox(base, 0, 0, -6.5F, -0.5F, -6.5F, 1, 1, 1, 0.0F, false));
		base.cubeList.add(new ModelBox(base, 0, 0, -1.0F, -0.5F, -1.0F, 1, 1, 1, 0.0F, false));
		base.cubeList.add(new ModelBox(base, 0, 0, -12.0F, -0.5F, -1.0F, 1, 1, 1, 0.0F, false));
		base.cubeList.add(new ModelBox(base, 0, 0, -6.5F, -1.5F, -6.5F, 1, 1, 12, 0.0F, false));
		base.cubeList.add(new ModelBox(base, 0, 0, -6.5F, -6.5F, -1.0F, 1, 5, 1, 0.0F, false));
		base.cubeList.add(new ModelBox(base, 0, 0, -6.5F, -0.5F, 4.5F, 1, 1, 1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		seat.render(f5);
		base.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}