package model.action;

import java.awt.Point;

import model.Direction;

public class MoveAction {
	private Point oldPos, newPos;
	private Direction facingDirection;

	public Point getOldPos() {
		return oldPos;
	}

	public void setOldPos(Point oldPos) {
		this.oldPos = oldPos;
	}

	public Point getNewPos() {
		return newPos;
	}

	public void setNewPos(Point newPos) {
		this.newPos = newPos;
	}

	public Direction getFacingDirection() {
		return facingDirection;
	}

	public void setFacingDirection(Direction facingDirection) {
		this.facingDirection = facingDirection;
	}

}
