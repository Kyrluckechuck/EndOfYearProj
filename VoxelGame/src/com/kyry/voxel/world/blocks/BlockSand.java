package com.kyry.voxel.world.blocks;

import com.kyry.voxel.utilites.Constants;
import com.kyry.voxel.utilites.Spritesheet;
import com.nishu.utils.Color4f;

public class BlockSand extends Block{

	@Override
	public short getId() {
		return 5;
	}

	@Override
	public Color4f getColor() {
		return Color4f.DEFAULT;
	}

	@Override
	public float[] getTexCoords() {
		float actualSize = Constants.TextureSize;
		float size = Spritesheet.tiles.uniformSize();
		int height = (int) (getId() / (float)actualSize);
		return new float[] { (getId()-(size*height)) * size, height * size };
	}
}