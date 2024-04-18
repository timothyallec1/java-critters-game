import java.awt.*;
import java.util.*;
public class Lion extends Critter {
    private Color color; // depends on the move
    //    private String string;
    private int count = 0;


    // constructor of a lion class
    public Lion() {
        updateColor();

    }


    private void updateColor() {
        Random rand = new Random();
        int num = rand.nextInt(3);
        if (count % 3 == 0) {
            if (num == 0) {
                color = Color.RED;
            } else if (num == 1) {
                color = Color.GREEN;
            } else {
                color = color.BLUE;
            }
        }
    }

    @Override
    public Action getMove(CritterInfo info) {
        count++;
        updateColor();

        Critter.Neighbor right = info.getRight();
        Critter.Neighbor front = info.getFront();
        if (front == Neighbor.WALL) {
            return Action.LEFT;
        }
        if(front == Neighbor.OTHER){
            return Action.INFECT;
        }
        if (right == Neighbor.WALL) {
            return Action.LEFT;
        }
        if (front == Neighbor.SAME) {
            return Action.RIGHT;
        } else {
            return Action.HOP;
        }
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "L";

    }
}
