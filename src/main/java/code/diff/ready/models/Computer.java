package code.diff.ready.models;

public class Computer extends Player {

    public Computer(int number){
        super("Computer " + number);
    }

    @Override
    public Card discardFromHand(){

        int index = (int)(Math.random() * this.getHand().size());
        return this.getHand().remove(index);
    }
}
