package CS102_reUP.HangmanGame.Lab03_Part2;

import javax.swing.*;
import java.awt.*;

public class Lab03_main extends JFrame {

    public static BalloonsGamePanel balloonsPanel = new BalloonsGamePanel();

    public Lab03_main() {
        this.setTitle("Lab03 - Balloons");
        this.add(balloonsPanel);
        this.setLayout(new FlowLayout());
        this.pack();
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
    }

    public static void main(String[] args){
        new Lab03_main();
    }
}
