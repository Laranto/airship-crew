package model.character;

import java.awt.Point;

import model.Direction;
import model.action.MoveAction;
import model.object.ASObject;

public abstract class Chara extends ASObject {
	protected Direction facingDirection;
	protected MoveAction mvAction;

	public Chara() {
		position = new Point();
	}
	
	public abstract MoveAction move(Direction dir);
	public abstract void executeMoveAction(MoveAction action);
	
	public Point getPosition() {
		return position;
	}

	public MoveAction getMvAction() {
		return mvAction;
	}

	@Override
	public boolean isPassable() {
		return false;
	}

}
