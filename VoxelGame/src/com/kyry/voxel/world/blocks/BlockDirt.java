package com.kyry.voxel.world.blocks;

import com.kyry.voxel.utilities.Globals;
import com.kyry.voxel.utilities.Spritesheet;
import com.nishu.utils.Color4f;

public class BlockDirt extends Block{

	@Override
	public byte getId() {
		return 4;
	}

	@Override
	public Color4f getColor() {
		return Color4f.DEFAULT;
	}

	@Override
	public float[] getTexCoords() {
		float actualSize = Globals.TextureSize;
		float size = Spritesheet.blocks.uniformSize();
		int height = (int) (getId() / (float)actualSize);
		return new float[] { (getId()-(size*height)) * size, height * size };
	}
	@Override
	public String getName() {
		return "Dirt";
	}
}
