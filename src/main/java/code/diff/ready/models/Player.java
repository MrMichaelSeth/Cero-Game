package code.diff.ready.models;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

abstract class Player {

    private int score;
    private ArrayList<Card> hand;
    private String name;

    public Player(String name){
        this.score = 0;
        this.hand = new ArrayList<>();
        this.name = name;
    }

    public void addCardToHand(Card card){
        this.hand.add(card);
    }

    //Card is the return type since we want a card to be handed back
    //This is where the user picks the card to discard
    public abstract Card discardFromHand();

    public ArrayList<Card> getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "score=" + score +
                ", hand=" + hand +
                ", name='" + name + '\'' +
                '}';
    }
}
