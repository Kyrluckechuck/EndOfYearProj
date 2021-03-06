package com.kyry.voxel.geometry;

import static org.lwjgl.opengl.GL11.*;

import com.kyry.voxel.utilities.Spritesheet;
import com.nishu.utils.Color4f;

public class Shape {

	public static void createCube(float x, float y, float z, Color4f color,
			float[] texCoords, float size) {
		if (texCoords.length == 2) {
			// bottom face
			glTexCoord2f(texCoords[0], texCoords[1]);
			glVertex3f(x, y, z + size);
			glTexCoord2f(texCoords[0] + Spritesheet.blocks.uniformSize(),
					texCoords[1]);
			glVertex3f(x + size, y, z + size);
			glTexCoord2f(texCoords[0] + Spritesheet.blocks.uniformSize(),
					texCoords[1] + Spritesheet.blocks.uniformSize());
			glVertex3f(x + size, y, z);
			glTexCoord2f(texCoords[0],
					texCoords[1] + Spritesheet.blocks.uniformSize());
			glVertex3f(x, y, z);

			// top face
			glTexCoord2f(texCoords[0], texCoords[1]);
			glVertex3f(x, y + size, z);
			glTexCoord2f(texCoords[0] + Spritesheet.blocks.uniformSize(),
					texCoords[1]);
			glVertex3f(x + size, y + size, z);
			glTexCoord2f(texCoords[0] + Spritesheet.blocks.uniformSize(),
					texCoords[1] + Spritesheet.blocks.uniformSize());
			glVertex3f(x + size, y + size, z + size);
			glTexCoord2f(texCoords[0],
					texCoords[1] + Spritesheet.blocks.uniformSize());
			glVertex3f(x, y + size, z + size);

			// front face
			glTexCoord2f(texCoords[0], texCoords[1]);
			glVertex3f(x, y, z);
			glTexCoord2f(texCoords[0] + Spritesheet.blocks.uniformSize(),
					texCoords[1]);
			glVertex3f(x + size, y, z);
			glTexCoord2f(texCoords[0] + Spritesheet.blocks.uniformSize(),
					texCoords[1] + Spritesheet.blocks.uniformSize());
			glVertex3f(x + size, y + size, z);
			glTexCoord2f(texCoords[0],
					texCoords[1] + Spritesheet.blocks.uniformSize());
			glVertex3f(x, y + size, z);

			// back face
			glTexCoord2f(texCoords[0], texCoords[1]);
			glVertex3f(x, y + size, z + size);
			glTexCoord2f(texCoords[0] + Spritesheet.blocks.uniformSize(),
					texCoords[1]);
			glVertex3f(x + size, y + size, z + size);
			glTexCoord2f(texCoords[0] + Spritesheet.blocks.uniformSize(),
					texCoords[1] + Spritesheet.blocks.uniformSize());
			glVertex3f(x + size, y, z + size);
			glTexCoord2f(texCoords[0],
					texCoords[1] + Spritesheet.blocks.uniformSize());
			glVertex3f(x, y, z + size);

			// left face
			glTexCoord2f(texCoords[0], texCoords[1]);
			glVertex3f(x + size, y, z);
			glTexCoord2f(texCoords[0] + Spritesheet.blocks.uniformSize(),
					texCoords[1]);
			glVertex3f(x + size, y, z + size);
			glTexCoord2f(texCoords[0] + Spritesheet.blocks.uniformSize(),
					texCoords[1] + Spritesheet.blocks.uniformSize());
			glVertex3f(x + size, y + size, z + size);
			glTexCoord2f(texCoords[0],
					texCoords[1] + Spritesheet.blocks.uniformSize());
			glVertex3f(x + size, y + size, z);

			// right face
			glTexCoord2f(texCoords[0], texCoords[1]);
			glVertex3f(x, y, z + size);
			glTexCoord2f(texCoords[0] + Spritesheet.blocks.uniformSize(),
					texCoords[1]);
			glVertex3f(x, y, z);
			glTexCoord2f(texCoords[0] + Spritesheet.blocks.uniformSize(),
					texCoords[1] + Spritesheet.blocks.uniformSize());
			glVertex3f(x, y + size, z);
			glTexCoord2f(texCoords[0],
					texCoords[1] + Spritesheet.blocks.uniformSize());
			glVertex3f(x, y + size, z + size);
		} else if (texCoords.length > 2) {
			/*
			 * bottom - first top - second front - third back - fourth left -
			 * fifth right - sixth
			 */
			// bottom face (0, 1)
			glTexCoord2f(texCoords[0], texCoords[1]);
			glVertex3f(x, y, z + size);
			glTexCoord2f(texCoords[0] + Spritesheet.blocks.uniformSize(),
					texCoords[1]);
			glVertex3f(x + size, y, z + size);
			glTexCoord2f(texCoords[0] + Spritesheet.blocks.uniformSize(),
					texCoords[1] - Spritesheet.blocks.uniformSize());
			glVertex3f(x + size, y, z);
			glTexCoord2f(texCoords[0],
					texCoords[1] - Spritesheet.blocks.uniformSize());
			glVertex3f(x, y, z);

			// top face (2, 3)
			glTexCoord2f(texCoords[2], texCoords[3]);
			glVertex3f(x, y + size, z);
			glTexCoord2f(texCoords[2] + Spritesheet.blocks.uniformSize(),
					texCoords[3]);
			glVertex3f(x + size, y + size, z);
			glTexCoord2f(texCoords[2] + Spritesheet.blocks.uniformSize(),
					texCoords[3] - Spritesheet.blocks.uniformSize());
			glVertex3f(x + size, y + size, z + size);
			glTexCoord2f(texCoords[2],
					texCoords[3] - Spritesheet.blocks.uniformSize());
			glVertex3f(x, y + size, z + size);

			// front face (4, 5)
			glTexCoord2f(texCoords[4], texCoords[5]);
			glVertex3f(x, y, z);
			glTexCoord2f(texCoords[4] + Spritesheet.blocks.uniformSize(),
					texCoords[5]);
			glVertex3f(x + size, y, z);
			glTexCoord2f(texCoords[4] + Spritesheet.blocks.uniformSize(),
					texCoords[5] - Spritesheet.blocks.uniformSize());
			glVertex3f(x + size, y + size, z);
			glTexCoord2f(texCoords[4],
					texCoords[5] - Spritesheet.blocks.uniformSize());
			glVertex3f(x, y + size, z);

			// back face (6, 7)
			// glColor4f(color.r, color.g, color.b, color.a);
			glTexCoord2f(texCoords[6], texCoords[7]);
			glVertex3f(x, y + size, z + size);
			glTexCoord2f(texCoords[6] + Spritesheet.blocks.uniformSize(),
					texCoords[7]);
			glVertex3f(x + size, y + size, z + size);
			glTexCoord2f(texCoords[6] + Spritesheet.blocks.uniformSize(),
					texCoords[7] + Spritesheet.blocks.uniformSize());
			glVertex3f(x + size, y, z + size);
			glTexCoord2f(texCoords[6],
					texCoords[7] + Spritesheet.blocks.uniformSize());
			glVertex3f(x, y, z + size);

			// left face (8, 9)
			glTexCoord2f(texCoords[8], texCoords[9]);
			glVertex3f(x + size, y, z);
			glTexCoord2f(texCoords[8] + Spritesheet.blocks.uniformSize(),
					texCoords[9]);
			glVertex3f(x + size, y, z + size);
			glTexCoord2f(texCoords[8] + Spritesheet.blocks.uniformSize(),
					texCoords[9] - Spritesheet.blocks.uniformSize());
			glVertex3f(x + size, y + size, z + size);
			glTexCoord2f(texCoords[8],
					texCoords[9] - Spritesheet.blocks.uniformSize());
			glVertex3f(x + size, y + size, z);

			// right face (10, 11)
			glTexCoord2f(texCoords[10], texCoords[11]);
			glVertex3f(x, y, z + size);
			glTexCoord2f(texCoords[10] + Spritesheet.blocks.uniformSize(),
					texCoords[11]);
			glVertex3f(x, y, z);
			glTexCoord2f(texCoords[10] + Spritesheet.blocks.uniformSize(),
					texCoords[11] - Spritesheet.blocks.uniformSize());
			glVertex3f(x, y + size, z);
			glTexCoord2f(texCoords[10],
					texCoords[11] - Spritesheet.blocks.uniformSize());
			glVertex3f(x, y + size, z + size);
		}
	}

	public static void createSkybox(float x, float y, float z, Color4f color,
			float[] texCoords1, float[] texCoords2, float[] texCoords3,
			float[] texCoords4, float[] texCoords5, float[] texCoords6,
			float size) {
		// bottom face
		glTexCoord2f(texCoords3[0], texCoords3[1]);
		glVertex3f(x, y, z + size);
		glTexCoord2f(texCoords3[0] + Spritesheet.blocks.uniformSize(),
				texCoords3[1]);
		glVertex3f(x + size, y, z + size);
		glTexCoord2f(texCoords3[0] + Spritesheet.blocks.uniformSize(),
				texCoords3[1] + Spritesheet.blocks.uniformSize());
		glVertex3f(x + size, y, z);
		glTexCoord2f(texCoords3[0],
				texCoords3[1] + Spritesheet.blocks.uniformSize());
		glVertex3f(x, y, z);

		// top face
		glTexCoord2f(texCoords5[0], texCoords5[1]);
		glVertex3f(x, y + size, z);
		glTexCoord2f(texCoords5[0] + Spritesheet.blocks.uniformSize(),
				texCoords5[1]);
		glVertex3f(x + size, y + size, z);
		glTexCoord2f(texCoords5[0] + Spritesheet.blocks.uniformSize(),
				texCoords5[1] + Spritesheet.blocks.uniformSize());
		glVertex3f(x + size, y + size, z + size);
		glTexCoord2f(texCoords5[0],
				texCoords5[1] + Spritesheet.blocks.uniformSize());
		glVertex3f(x, y + size, z + size);

		// front face
		glTexCoord2f(texCoords1[0], texCoords1[1]);
		glVertex3f(x, y, z);
		glTexCoord2f(texCoords1[0] + Spritesheet.blocks.uniformSize(),
				texCoords1[1]);
		glVertex3f(x + size, y, z);
		glTexCoord2f(texCoords1[0] + Spritesheet.blocks.uniformSize(),
				texCoords1[1] + Spritesheet.blocks.uniformSize());
		glVertex3f(x + size, y + size, z);
		glTexCoord2f(texCoords1[0],
				texCoords1[1] + Spritesheet.blocks.uniformSize());
		glVertex3f(x, y + size, z);

		// back face
		glTexCoord2f(texCoords6[0], texCoords6[1]);
		glVertex3f(x, y + size, z + size);
		glTexCoord2f(texCoords6[0] + Spritesheet.blocks.uniformSize(),
				texCoords6[1]);
		glVertex3f(x + size, y + size, z + size);
		glTexCoord2f(texCoords6[0] + Spritesheet.blocks.uniformSize(),
				texCoords6[1] + Spritesheet.blocks.uniformSize());
		glVertex3f(x + size, y, z + size);
		glTexCoord2f(texCoords6[0],
				texCoords6[1] + Spritesheet.blocks.uniformSize());
		glVertex3f(x, y, z + size);

		// left face
		glTexCoord2f(texCoords2[0], texCoords2[1]);
		glVertex3f(x + size, y, z);
		glTexCoord2f(texCoords2[0] + Spritesheet.blocks.uniformSize(),
				texCoords2[1]);
		glVertex3f(x + size, y, z + size);
		glTexCoord2f(texCoords2[0] + Spritesheet.blocks.uniformSize(),
				texCoords2[1] + Spritesheet.blocks.uniformSize());
		glVertex3f(x + size, y + size, z + size);
		glTexCoord2f(texCoords2[0],
				texCoords2[1] + Spritesheet.blocks.uniformSize());
		glVertex3f(x + size, y + size, z);

		// right face
		glTexCoord2f(texCoords4[0], texCoords4[1]);
		glVertex3f(x, y, z + size);
		glTexCoord2f(texCoords4[0] + Spritesheet.blocks.uniformSize(),
				texCoords4[1]);
		glVertex3f(x, y, z);
		glTexCoord2f(texCoords4[0] + Spritesheet.blocks.uniformSize(),
				texCoords4[1] + Spritesheet.blocks.uniformSize());
		glVertex3f(x, y + size, z);
		glTexCoord2f(texCoords4[0],
				texCoords4[1] + Spritesheet.blocks.uniformSize());
		glVertex3f(x, y + size, z + size);
	}
}