package com.kyry.voxel.world.blocks;

import com.kyry.voxel.utilities.Globals;
import com.kyry.voxel.utilities.Spritesheet;
import com.nishu.utils.Color4f;

public class BlockSkybox1 extends Block {

	@Override
	public byte getId() {
		return 81;
	}

	@Override
	public Color4f getColor() {
		return Color4f.DEFAULT;
	}

	@Override
	public float[] getTexCoords() {
		float actualSize = Globals.TextureSize;
		float size = Spritesheet.blocks.uniformSize();
		int height = (int) (getId() / (float) actualSize);
		if (height == (getId() / (float) actualSize)) {
			return new float[] { (getId() - (actualSize * height)) * size,
					(height) * size };
		} else {
			return new float[] { (getId() - (actualSize * height)) * size,
					(height + 1) * size };
		}
		// Height is (+1) to account for the fact it's actually 1 larger than
		// the column.
	}
	@Override
	public String getName() {
		return "Skybox1";
	}
}
