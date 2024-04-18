import java.awt.*;

public class Giant extends Critter {

    private String string ="s";
    private int count = 0;

    //constructor
    public Giant() {
        updateString();

    }
    public void updateString() {
        if(count % 6 == 0){
            if(string == "s"){
                string = "fee";
            } else if(string == "fee"){
                string = "fie";
            } else if(string == "fie"){
                string = "foe";
            } else if(string == "foe"){
                string = "fum";
            } else if(string == "fum"){
                string = "fee";
            }
        }
    }

    @Override
    public Action getMove(CritterInfo info) {
        count++;
        updateString();

     Critter.Neighbor front = info.getFront();
        if (front == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (front == Neighbor.EMPTY) {
            return Action.HOP;
        } else {
            return Action.RIGHT;
        }
    }

    @Override
    public Color getColor() {
        return Color.GRAY;
    }

    @Override
    public String toString() {
        return string;
    }
}
