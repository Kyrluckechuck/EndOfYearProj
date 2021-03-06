package com.kyry.voxel.utilities;

public class Spritesheet {
	/* Definitions */
	private Texture texture;
	private String path;
	private float size;
	/* Set up spritesheet */
	public static Spritesheet blocks = new Spritesheet("textures/spritesheets/blocks/blocks.png", 16);
	
	public Spritesheet(String path, float size) {
		this.path = path;
		this.size = 1 / size;
		load();
	}
	
	private void load() {
		texture = Texture.loadTexture(path);
	}
	
	public void bind() {
		texture.bind();
	}
	
	public void unbind() {
		texture.unbind();
	}
	
	public void delete() {
		texture.delete();
	}
	
	public float uniformSize() {
		return size;
	}
}
