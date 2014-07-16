package model;

import java.util.Vector;

public enum Direction {
    NORTH(0,-1),SOUTH(0,1),EAST(1,0),WEST(-1,0);
    private Vector<Integer> directionVector;
    private Direction(int x,int y) {
        directionVector = new Vector<>(2);
        directionVector.add(x);
        directionVector.add(y);
    }
    public Vector<Integer> getDirectionVector() {
        return directionVector;
    }
    
    /**
     * @return the starting character of the direction in lower-case
     */
    public String getShort(){
		return this.name().substring(0, 1).toLowerCase();
    }
}
