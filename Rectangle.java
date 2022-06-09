package CS102_reUP.HangmanGame.Lab03_Part2;
/**
 * @ author Zeynep Doga Dellal
 * @ date 2.11.2021
 */

public class Rectangle extends Shape implements Selectable {
    int width;
    int height;

    public Rectangle(int width, int height, int x, int y){
        this.width = width;
        this.height = height;
        setLocation(x, y);
    }

    public double getArea(){
        return height*width;
    }

    public double getPerimeter(){
        return 2*(height+width);
    }

    public boolean getSelected(){
        return selected;
    }

    public void setSelected(boolean selected){
        this.selected = selected;
    }

    public Shape contains(int x, int y){

        if(getX() <= x && getX() + width >= x && getY() <= y && getY() + width >= y ){
            return this;
        }
        return null;
    }

    public String getInfo(){
        String s = "Width is " + width + " and height is " + height + ", area is " + getArea() + ", perimeter is " + getPerimeter();
        if(getSelected()){
            return s + " and rectangle is selected.";
        }
        else{
            return s + " and rectangle is not selected.";
        }
    }
}
