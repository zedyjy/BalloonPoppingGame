package CS102_reUP.HangmanGame.Lab03_Part2;

/**
 * @ author Zeynep Doga Dellal
 * @ date 2.11.2021
 */

public abstract class Shape implements Locatable {
    int x;
    int y;
    public boolean selected;

    public abstract double getArea();
    public abstract double getPerimeter();

    public Shape(){
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
    }
}
