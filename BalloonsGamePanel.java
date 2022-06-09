package CS102_reUP.HangmanGame.Lab03_Part2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BalloonsGamePanel extends JPanel {

    public final int  DEFAULT_RADIUS = 25;
    ShapeContainer balloons;
    Timer timer;
    int elapsedTime;
    int points;
    JLabel pointsLabel = new JLabel();

    public BalloonsGamePanel(){
        this.setVisible(true);
        this.setPreferredSize(new Dimension(800, 600));
        this.balloons = new ShapeContainer();
        this.setBackground(Color.pink);
        play();
        points=0;
    }

    public void play(){
        this.elapsedTime = 0;
        timer = new Timer(250, new BalloonsGamePanel.GrowListener());
        this.createRandomBalloons(25,800,600);
        this.timer.start();
        BurstListener burstListener = new BurstListener();
        this.addMouseListener(burstListener);
        this.add(pointsLabel).setVisible(true);
    }

    private class GrowListener implements ActionListener {
        public GrowListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < balloons.shapeList.size() - 1; i++) {
                    ((Balloons) balloons.shapeList.get(i)).grow();
                }

            BalloonsGamePanel.this.balloons.removeSelected();
            if (BalloonsGamePanel.this.balloons.size() < 15) {
                BalloonsGamePanel.this.createRandomBalloons( 25,BalloonsGamePanel.this.getWidth(), BalloonsGamePanel.this.getHeight());
            }

            BalloonsGamePanel.this.repaint();
            ++BalloonsGamePanel.this.elapsedTime;
            if (BalloonsGamePanel.this.elapsedTime >= 150) {
                BalloonsGamePanel.this.timer.stop();
                int again = JOptionPane.showConfirmDialog(BalloonsGamePanel.this, "Play again? ", "Game over", 0);
                if (again == 0) {
                    BalloonsGamePanel.this.play();
                }
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i = 0; i < balloons.shapeList.size()-1; i++){
            ((Drawable)balloons.shapeList.get(i)).draw(g);
            ((Balloons)balloons.shapeList.get(i)).grow();
        }
    }

    public class BurstListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            balloons.selectAllAt(e.getX(),e.getY());
            balloons.removeSelected();
            BalloonsGamePanel.this.createRandomBalloons(2,800,600);
            pointsLabel.setText("Points: "+(balloons.selectAllAt(e.getX(),e.getY())));
        }
    }

    public void createRandomBalloons(int num, int xP, int yP){
        for(int i = 0; i < num; ++i) {
            int x = (int)(Math.random() * xP);
            int y = (int)(Math.random() * yP);
            int radius = (int)(Math.random()*DEFAULT_RADIUS);
            Balloons b = new Balloons(radius,x, y);
            this.balloons.add(b);
        }
    }
}
