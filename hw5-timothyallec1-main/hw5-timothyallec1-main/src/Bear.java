import java.awt.*;

public class Bear extends Critter {
    // private variables to measure the count of the instances and polarity of the bear
    private int count;
    private boolean polar;
    private Color color;
    private String string;

    // constructor for the critter bear
    public Bear(boolean polar) {
        this.count = 0;
        this.polar = polar;
        updateColor();
        updateString();

    }
    public Color updateColor(){
        if (this.polar) {
            return color = Color.WHITE;
        } else{
            return color = Color.BLACK;
        }
    }
    public String updateString(){
        count++;
        if (count % 2 == 1) {
            string = "/";
        } else {
            string = "\\";
        }
        return string;
    }


    // returns the color of the bear depending on the boolean polar (white if true, black if false)
    public Color getColor() {
        return color;
    }


    // returns the string value of the bear
    public String toString() {
        return string;
    }
    // returns the move to be made by the bear
    public Action getMove(CritterInfo info) {
        getColor();
        updateString();
        Neighbor n = info.getFront();
        if (n == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.LEFT;
        }
    }
}