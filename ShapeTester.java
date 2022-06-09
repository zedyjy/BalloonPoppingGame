package CS102_reUP.HangmanGame.Lab03_Part2;
/**
 * @ author Zeynep Doga Dellal
 * @ date 2.11.2021
 */

import java.util.Scanner;

public class ShapeTester {
    public static void main (String [] args){
        Scanner input = new Scanner(System.in);
        ShapeContainer c = new ShapeContainer();
        int choice;

        do{
            System.out.println("1- Create an empty shape container.");
            System.out.println("2- Add a rectangle.");
            System.out.println("3- Add a square.");
            System.out.println("4- Add a circle.");
            System.out.println("5- Add a triangle.");
            System.out.println("6- Compute the total area.");
            System.out.println("7- Compute perimeter.");
            System.out.println("8- Print information about shapes.");
            System.out.println("9- Find the first shape that contains the given coordinates");
            System.out.println("10- Remove selected shapes.");
            System.out.println("11- Quit.");

            choice = input.nextInt();

            if(choice == 1){
                c = new ShapeContainer();
            }
            else if(choice == 2){
                System.out.println("Please enter width:");
                int width = input.nextInt();
                System.out.println("Please enter height");
                int height = input.nextInt();
                System.out.println("Enter location, X axis: ");
                int x = input.nextInt();
                System.out.println("Enter location on Y axis: ");
                int y = input.nextInt();

                c.add(new Rectangle(width, height, x, y));
            }
            else if(choice == 3){
                System.out.println("Please enter side length:");
                int side = input.nextInt();
                System.out.println("Enter location, X axis: ");
                int x = input.nextInt();
                System.out.println("Enter location on Y axis: ");
                int y = input.nextInt();

                c.add(new Square(side, x, y));
            }
            else if(choice == 4){
                System.out.println("Please enter radius:");
                int radius = input.nextInt();
                System.out.println("Enter location, X axis: ");
                int x = input.nextInt();
                System.out.println("Enter location on Y axis: ");
                int y = input.nextInt();

                c.add(new Circle(radius,x,y));
            }
            else if(choice == 6){
                System.out.println("The total area is: " + c.getArea());
                }
            else if(choice == 7){
                System.out.println("The total perimeter is: " + c.getPerimeter());
            }
            else if(choice == 8){
                System.out.println(c.toString());
            }
            else if(choice == 9){
                System.out.println("Please enter X: ");
                int x = input.nextInt();
                System.out.println("Please enter Y: ");
                int y = input.nextInt();
                System.out.println("The first shape that contains given x and y is: " + c.findTheFirstShape(x,y));
            }
            else if(choice == 10){
                c.removeSelected();
                System.out.println("Selected shape is removed.");
            }
            else if(choice == 11){
                System.out.println("See you next time!!");
            }
        }while(choice != 11);
    }
}
