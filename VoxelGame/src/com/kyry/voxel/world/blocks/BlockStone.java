package com.kyry.voxel.world.blocks;

import com.kyry.voxel.utilities.Globals;
import com.kyry.voxel.utilities.Spritesheet;
import com.nishu.utils.Color4f;

public class BlockStone extends Block{

	@Override
	public byte getId() {
		return 3;
	}

	@Override
	public Color4f getColor() {
		return Color4f.GRAY;
	}

	@Override
	public float[] getTexCoords() {
		float actualSize = Globals.TextureSize;
		float size = Spritesheet.blocks.uniformSize();
		int height = (int) (getId() / (float)actualSize);
		return new float[] { (getId()-(size*height) -1) * size, height * size };
	}
	@Override
	public String getName() {
		return "Stone";
	}

}
