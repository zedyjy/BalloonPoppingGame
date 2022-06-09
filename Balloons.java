package CS102_reUP.HangmanGame.Lab03_Part2;

import java.awt.*;
import java.util.Random;

public class Balloons extends Circle implements Drawable{

    Random rand = new Random();
    float r = rand.nextFloat();
    float gColor = rand.nextFloat();
    float b2 = rand.nextFloat();
    Color randomColor = new Color(r, gColor, b2, 0.5f);

    public Balloons(int radius, int x, int y) {
        super(radius, x,y);
    }

    @Override
    public void draw(Graphics g) {

        int radius = this.getRadius();
        g.drawOval(this.getX() - radius, this.getY() - radius, radius * 2, radius * 2);
        g.fillOval(this.getX() - radius, this.getY() - radius, radius * 2, radius * 2);
        g.setColor(randomColor);
    }

    public void grow(){
        this.setRadius( this.getRadius()+1);
        if(getRadius()>75){
            burst();
        }
    }

    public void burst() {
        this.setRadius(0);
        this.setSelected(true);
    }
}
