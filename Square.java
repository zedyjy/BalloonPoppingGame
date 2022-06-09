package CS102_reUP.HangmanGame.Lab03_Part2;

/**
 * @ author Zeynep Doga Dellal
 * @ date 2.11.2021
 */
public class Square extends Rectangle {

    int side;

    public Square(int side, int x, int y){
        super(side, side, x, y);
        this.side = side;
        setLocation(x, y);
    }

    public String getInfo(){
        String s = "Square's sides are: " + side;
        if(getSelected()){
            s = s + " and square is selected.";
        }
        else{
            s = s + " and square is not selected.";
        }
        return s;
    }
}
