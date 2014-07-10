import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import sun.misc.Cache;

import model.character.Cat;
import model.character.Chara;
import model.map.Map;
import model.map.tilebase.TileEnum;
import controll.MainLoop;
import controll.input.HumanInput;
import display.ControlPanel;
import display.MainDisplay;


public class Main {
    
    private MainDisplay display; 
    private ControlPanel controlPane;
    private MainLoop loop;
    private HumanInput input;
    
    private void startClient(){
        createFrame();
        //Start a thread with the main loop (Logic Thread)
        new Thread(loop = new MainLoop()).start();
        loop.registerContainer(display);
        addInput();
        createMap();
    }


    private void createMenu() {
        JFrame menu = new JFrame("Airship Crew Menu");
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel menuPane = new JPanel(new GridLayout(2, 1));
        JButton joinButton = new JButton("Join");
        joinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                startClient();
            }
        });
        JButton hostButton = new JButton("Host");
        hostButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        menuPane.add(joinButton);
        menuPane.add(hostButton);
        menu.add(menuPane);
        menu.setSize(200, 100);
        menu.setVisible(true);
    }



    private void addInput() {
        input=new HumanInput();
        display.addKeyListener(input);
    }



    private void createMap() {
        Map map = new Map(40, 40);
        loop.setMap(map);
        display.setMap(map);
        Chara player = new Cat();
        input.setControlled(player);
        map.put(player,15,15);
        display.setPlayer(player);
        map.setMapTile(TileEnum.FLOOR_WOOD, 14, 15);
        map.setMapTile(TileEnum.FLOOR_WOOD, 15, 14);
        map.setMapTile(TileEnum.FLOOR_WOOD, 15, 15);
        map.setMapTile(TileEnum.FLOOR_WOOD, 15, 16);
        map.setMapTile(TileEnum.FLOOR_WOOD, 16, 15);
    }



    public void createFrame() {
        JFrame frame = new JFrame("Airship Crew");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(display = new MainDisplay(),BorderLayout.CENTER);
        frame.add(controlPane = new ControlPanel(), BorderLayout.EAST);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
    
    
    
    public static void main(String[] args) {
        Main entryPoint = new Main();
        if(args.length>1){
            entryPoint.startClient();
        }else{
            entryPoint.createMenu();
        }
    }
}
