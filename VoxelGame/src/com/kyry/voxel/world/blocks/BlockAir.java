package com.kyry.voxel.world.blocks;

import com.nishu.utils.Color4f;

public class BlockAir extends Block{

	@Override
	public byte getId() {
		return 0;
	}

	@Override
	public Color4f getColor() {
		return Color4f.WHITE;
	}

	@Override
	public float[] getTexCoords() {
		return new float[] {-1, -1};
	}
	
	@Override
	public String getName() {
		return "Air";
	}
}
