package controll.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import model.Direction;
import model.character.Chara;

public class HumanInput extends KeyAdapter {

    private Chara controlled;

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);

        if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
            controlled.move(Direction.WEST);
        }
        else if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            controlled.move(Direction.EAST);
        }
        else if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
            controlled.move(Direction.NORTH);
        }
        else if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
            controlled.move(Direction.SOUTH);
        }
    }

    public Chara getControlled() {
        return controlled;
    }

    public void setControlled(Chara controlled) {
        this.controlled = controlled;
    }
}
