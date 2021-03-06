package com.kyry.voxel.world.entities.mobs;

import com.kyry.voxel.utilities.GameObject;
import com.kyry.voxel.utilities.Globals;
import com.kyry.voxel.world.entities.Camera;
import com.kyry.voxel.world.entities.Entity;

public class Mob extends Entity implements GameObject{
	/* Definitions */
	private int mobID;
	private boolean isDead;

	public Mob(Camera camera, int id, int mobID) {
		this(camera, camera.getX(), camera.getY(), camera.getZ(), 0, 0, 0, id, mobID);
	}

	public Mob(Camera camera, float x, float y, float z, float rx, float ry, float rz, int id, int mobID) {
		super(camera, id);
		this.mobID = mobID;
	}

	@Override
	public void update() {
	}
	/* Move the mob */
	public void mobMove() {
		getCamera().updateMouse();
		getCamera().updateKeyboard((float)(1/Globals.FPS), 4f);
		setPos(getCamera().getX(), getCamera().getY(), getCamera().getZ());
		setRot(getCamera().getPitch(), getCamera().getYaw(), getCamera().getRoll());
	}
	
	@Override
	public void mobRender() {
	}

	@Override
	public void mobDispose() {
	}
	/* Get mob ID */
	public int getID() {
		return mobID;
	}
	/* Set what type of mob it is */
	public void set(int mobID) {
		this.mobID = mobID;
	}
	/* Check if the mob is dead */
	public boolean isDead() {
		return isDead;
	}
	/* Kill/Resurrect the mob */
	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
}
