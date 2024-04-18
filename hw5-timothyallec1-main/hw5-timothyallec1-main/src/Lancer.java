import java.awt.*;
import java.io.IOException;
import java.util.Random;

// completed on 11/3/22 by Timothy Allec
//collaborated with Kai, Phinehas, and Vincent
// this is my zombie class :)
public class Lancer extends Critter {
    public int count = 0;
    public String string = "l";
    public Color color;
    public Color orange = new Color(255, 127, 80);
    public Color purple = new Color(120, 72, 130);


    public Lancer() { // constructors
        updateColor();
        updateString();

    }

    public Color updateColor() { // randomly generates the color of the rainbow in relation to each string possibility
        Random rand = new Random();
        int num = rand.nextInt(7);
        if (num == 0) {
            color = Color.BLACK;
        } else if (num == 1) {
            color = Color.RED;
        } else if (num == 2) {
            color = Color.ORANGE;
        } else if (num == 3) {
            color = Color.YELLOW;
        } else if (num == 4) {
            color = Color.green;
        } else if (num == 5) {
            color = Color.BLUE;
        } else if (num == 6) {
            color = purple;
        }
        if (string == "z") {
            color = purple;
        }
        if (string == "zo") {
            color = Color.blue;
        }
        if (string == "zom") {
            color = Color.green;
        }
        if (string == "zomb") {
            color = Color.yellow;
        }
        if (string == "zombi") {
            color = orange;
        }
        if (string == "ZOMBIE") {
            color = Color.RED;
        }
        return color;
    }

    public void updateString() {// increments every 3 moves to spell out "ZOMBIE"
        if (count % 3 == 0) {
            if (string == "l") {
                string = "z";
            } else if (string == "z") {
                string = "zo";
            } else if (string == "zo") {
                string = "zom";
            } else if (string == "zom") {
                string = "zomb";
            } else if (string == "zomb") {
                string = "zombi";
            } else if (string == "zombi") {
                string = "ZOMBIE";
            } else if (string == "ZOMBIE") {
                string = "z";
            }
        }
    }

    @Override
    public Action getMove(CritterInfo info) { // this create the moves for my critter
        count++;
        updateColor();
        updateString();

        Critter.Neighbor front = info.getFront();
        Critter.Neighbor left = info.getLeft();
        Critter.Neighbor right = info.getRight();


        if(front == Neighbor.EMPTY ){
            return Action.HOP;
        } else if (front == Neighbor.OTHER){
            return Action.INFECT;
        }
        else if(right == Neighbor.WALL && left == Neighbor.EMPTY){
            return Action.INFECT;

        }
        else {
            return Action.LEFT;
        }
    }

    @Override
    public Color getColor() {
        return color;
    }
    @Override
    public String toString() {
        return string;
    }
}
