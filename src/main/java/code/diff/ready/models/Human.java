package code.diff.ready.models;

import java.util.Scanner;

public class Human extends Player{

    public Human(String name){
        super(name);
    }

    @Override
    public Card discardFromHand(){

        //shows the user their hand
        System.out.println("Hello, " + this.getName() + " this is your hand: ");
        System.out.println(this.getHand());
        System.out.println("What is the index of card you want to discard?: ");

        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();

        return this.getHand().remove(index);
    }
}
