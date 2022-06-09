package CS102_reUP.HangmanGame.Lab03_Part2;
/**
 * @ author Zeynep Doga Dellal
 * @ date 2.11.2021
 */

import java.util.ArrayList;

public class ShapeContainer {

    public ArrayList<Shape> shapeList= new ArrayList();
    public int count = 0;

    public ShapeContainer(){

    }

    public void add(Shape s) {
        shapeList.add(s);
    }

    public double getArea() {
        double area = 0;
        for (Shape i : shapeList) {
            area += i.getArea();
        }
        return area;
    }

    public double getPerimeter() {
        double perimeter = 0;
        for (Shape i : shapeList) {
            perimeter += i.getPerimeter();
        }
        return perimeter;
    }

    public String toString() {
        String s = "";
        for (Shape i : shapeList) {
            if (i instanceof Rectangle) {
                s += ((Rectangle) i).getInfo() + "\n";
            } else if (i instanceof Square) {
                s += ((Square) i).getInfo() + "\n";
            } else if (i instanceof Circle) {
                s += ((Circle) i).getInfo() + "\n";
            }
        }
        return s;
    }

    public Shape findTheFirstShape(int x, int y) {
        for (Shape i : shapeList) {
            if (i instanceof Selectable && ((Selectable) i).contains(x, y) != null) {
                ((Rectangle) i).setSelected(true);
                return i;
            }
        }
        return null;
    }

    public void removeSelected() {
        for(int i = 0; i < shapeList.size(); ++i) {
            if (((Circle)(shapeList.get(i))).isSelected()) {
                shapeList.remove(i);
                --i;
            }
        }
    }

    public int size() {
        return shapeList.size();
    }

    public Shape contains(int x, int y) {
        Shape s = null;
        for (Shape i : shapeList) {
            if (i instanceof Selectable && ((Selectable) i).getSelected()) {
                ((Selectable) i).contains(x,y);
                s = ((Selectable) i).contains(x,y);
            }
        }
        return s;
    }

    public int selectAllAt(int x, int y) {

        for(Shape i : shapeList){
            Shape s = ((Selectable)i).contains(x,y);
            if(s != null){
                ((Selectable) s).setSelected(true);
                count++;
            }
        }
        return count;
    }
}
