// EGR222 Homework 5 (Critters)
// Author: Timothy Allec. created on 10/31/22
//          collaborated with Vincent, Wyatt, Phinehas, Grace
//

public class CritterMain {
    public static void main(String[] args) {
        CritterFrame frame = new CritterFrame(60, 40);

        // uncomment each of these lines as you complete these classes
        frame.add(30, Bear.class);
        frame.add(30, Lion.class);
        frame.add(30, Giant.class);
        frame.add(30, Lancer.class);

        frame.add(30, FlyTrap.class);
        frame.add(30, Food.class);
//        frame.add(30, Eagle.class);

        frame.start();

    }
}