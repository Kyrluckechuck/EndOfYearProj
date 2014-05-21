package com.kyry.voxel.world;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluPerspective;

import java.awt.Font;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.opengl.TextureImpl;

import com.nishu.utils.Color4f;
import com.nishu.utils.GameLoop;
import com.nishu.utils.Screen;
import com.bulletphysics.linearmath.Transform;
import com.kyry.voxel.utilites.Constants;
import com.kyry.voxel.utilites.Spritesheet;
import com.kyry.voxel.world.tiles.Tile;

public class World extends Screen {

	public static final int AIRCHUNK = 0, MIXEDCHUNK = 1;

	private WorldManager worldManager;
	private TrueTypeFont font;

	private boolean renderText = true;

	public World() {
		initGL();
		init();
	}

	@Override
	public void init() {

		Spritesheet.tiles.bind();
		Tile.createTileMap();

		Font tempFont = new Font("Arial", Font.PLAIN, 16);
		font = new TrueTypeFont(tempFont, true);

		worldManager = new WorldManager();
	}

	@Override
	public void initGL() {
		glTexEnvi(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_MODULATE);
		glEnable(GL_CULL_FACE);
		glEnable(GL_TEXTURE_2D);

		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glDisable(GL_LIGHTING);
	}

	@Override
	public void update() {
		input();
		worldManager.update();
	}

	private void input() {
		if (Mouse.isButtonDown(0)) {
			Mouse.setGrabbed(true);
		}
		while (Keyboard.next()) {
			if (Keyboard.getEventKeyState()) {
				if (Keyboard.isKeyDown(Keyboard.KEY_F3)) {
					renderText = !renderText;
				}
			}
		}
	}

	@Override
	public void render() {
		render3D();
		logic();
		worldRender();
		//skyBoxRender();
		
		glLoadIdentity();

		if (renderText) {
			render2D();
			renderText();
		}
		
	}


	private void logic() {
		worldManager.logic();
	}
	private void worldRender(){
		worldManager.render();
	}
	private void skyBoxRender() {
		worldManager.skyBoxRender();
		
	}


	private void renderText() {
		font.drawString(10, 15, "FPS: " + GameLoop.getFPS());
		font.drawString(10, 40, "X: "
				+ (int) worldManager.getMobManager().getPlayer().getX()
				+ " Y: "
				+ (int) worldManager.getMobManager().getPlayer().getY()
				+ " Z: "
				+ (int) worldManager.getMobManager().getPlayer().getZ());
		font.drawString(10, 65, "Rotx: "
				+ (int) worldManager.getMobManager().getPlayer().getPitch()
				+ " Roty: "
				+ (int) worldManager.getMobManager().getPlayer().getYaw()
				+ " Rotz: "
				+ (int) worldManager.getMobManager().getPlayer().getRoll());
		font.drawString(10, 90, "Chunks: " + Constants.chunksLoaded + " ("
				+ Constants.chunksFrustum + ")");
		// int p =

		font.drawString(10, 120, "Chunks: "
				+ worldManager.activeChunks.get(0).tiles[0][0][0]);
		font.drawString(
				10,
				150,
				"vector data: "
						+ worldManager.physicsWorld.getPlayerBody()
								.getWorldTransform(new Transform()).origin.x
						+ " " + worldManager.physicsWorld.getPlayerBody()
						.getWorldTransform(new Transform()).origin.y
						+ " " + worldManager.physicsWorld.getPlayerBody()
						.getWorldTransform(new Transform()).origin.z
						+ " " + Constants.FPS);

		TextureImpl.unbind();

	}

	public void render2D() {
		glCullFace(GL_BACK);
		glClearDepth(1);
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();

		glOrtho(0, Constants.WIDTH, Constants.HEIGHT, 0, -1, 1);
		glViewport(0, 0, Constants.WIDTH, Constants.HEIGHT);
		glMatrixMode(GL_MODELVIEW);
	}

	public void render3D() {
		glCullFace(GL_FRONT);
		glViewport(0, 0, Display.getWidth(), Display.getHeight());
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();

		gluPerspective(67.0f, Constants.WIDTH / (float) Constants.HEIGHT, Constants.viewClose,
				Constants.viewDistance);
		glMatrixMode(GL_MODELVIEW);

		glEnable(GL_DEPTH_TEST);
	}

	@Override
	public void dispose() {
		Display.destroy();
		System.exit(0);
	}
}
