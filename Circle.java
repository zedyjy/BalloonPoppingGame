package CS102_reUP.HangmanGame.Lab03_Part2;

/**
 * @ author Zeynep Doga Dellal
 * @ date 2.11.2021
 */

public class Circle extends Shape implements Selectable {

    int radius;
    boolean selected;

    public Circle(){
        this.radius=0;
    }

    public Circle(int radius, int x, int y){
        this.radius = radius;
        setLocation(x, y);
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return this.radius;
    }

    public double getArea(){
        return (Math.PI)*radius*radius;
    }

    public double getPerimeter() {
        return Math.PI*2*radius;
    }

    public boolean getSelected(){
        return selected;
    }

    public void setSelected(boolean selected){
        this.selected = selected;
    }

    public Shape contains(int x, int y){

        if((getX() - x) * (getX() - x) +
                (getY() - y) * (getY() - y) <= radius * radius){
            return this;
        }
        return null;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public String getInfo(){
        String s = "Circle's radius is: " + radius;
        if(getSelected()){
            s = s + " and square is selected.";
        }
        else{
            s = s + " and square is not selected.";
        }
        return s;
    }
}
