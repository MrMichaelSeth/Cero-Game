package code.diff.ready;

import code.diff.ready.models.Game;
import code.diff.ready.models.Player;

public class Main {

    public static void main(String[] args) {

        Game g = new Game();

        //This is broken since Player is now an abstract class
        Player tariq = new Player("Tariq");
        Player kaleb = new Player("Burdman");
        Player val = new Player("Val");

        g.addPlayer(tariq);
        g.addPlayer(kaleb);
        g.addPlayer(val);

        g.deal();

        System.out.println(g);

    }

}
