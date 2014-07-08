package controll.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class HumanInput extends KeyAdapter {

    private Character controlled;
    
    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        if(e.getKeyCode()==KeyEvent.VK_A||e.getKeyCode()==KeyEvent.VK_LEFT){
            System.out.println("Left");
        }
    }
    
}
