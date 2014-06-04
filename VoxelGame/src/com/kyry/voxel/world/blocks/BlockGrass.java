package com.kyry.voxel.world.blocks;

import com.kyry.voxel.utilites.Spritesheet;
import com.nishu.utils.Color4f;

public class BlockGrass extends Block {

	/* 
	 * Texture coords for multi-textured tiles
	 * bottom - first
	 * top - second
	 * front - third
	 * back - fourth
	 * left - fifth
	 * right - sixth
	 */
	
	@Override
	public short getId() {
		return 2;
	}

	@Override
	public Color4f getColor() {
		return Color4f.WHITE;
	}

	@Override
	public float[] getTexCoords() {
		return new float[] { 4 * Spritesheet.tiles.uniformSize(), Spritesheet.tiles.uniformSize(), 
				Spritesheet.tiles.uniformSize(), Spritesheet.tiles.uniformSize(),
				3 * Spritesheet.tiles.uniformSize(), Spritesheet.tiles.uniformSize(),
				3 * Spritesheet.tiles.uniformSize(), 0,
				3 * Spritesheet.tiles.uniformSize(), Spritesheet.tiles.uniformSize(),
				3 * Spritesheet.tiles.uniformSize(), Spritesheet.tiles.uniformSize() };
	}
}
