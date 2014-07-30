package model.object;

import java.awt.Point;

import model.Drawable;

public abstract class ASObject implements Drawable{
	/**
	 * Recognition ID of the object
	 */
	public long id;
	/**
	 * Position of the Object on the Map
	 */
	protected Point position;

	protected boolean dragable;
	protected boolean pickupable;
	protected boolean passable;
	public boolean isDragable() {
		return dragable;
	}
	public boolean isPickupable() {
		return pickupable;
	}
	public boolean isPassable() {
		return passable;
	}
	
	
	
}
