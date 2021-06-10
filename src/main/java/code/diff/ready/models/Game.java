package code.diff.ready.models;

import code.diff.ready.enums.Color;
import code.diff.ready.enums.Direction;
import code.diff.ready.enums.Type;

import java.util.ArrayList;
import java.util.Collections;

public class Game {

    private static int STARTING_HAND_SIZE = 7;
    private ArrayList<Card> deck;
    private ArrayList<Player> players;
    private Card discardPile;
    private int currentPlayer;
    private Direction direction;

    public Game(){
        this.deck = generateDeck();
        this.players = new ArrayList<>();
        this.currentPlayer = 0;
        this.direction = Direction.CW;
    }

    private static ArrayList<Card> generateDeck(){

        ArrayList<Card> deck = new ArrayList<>();

        for(Color color : Color.values()){
            if(color != Color.BLACK) {
                for (Type type : Type.values()) {
                    if(type != Type.WILD && type != Type.DRAW_FOUR_WILD) {
                        deck.add(new Card(color, type));
                        if(type != Type.ZERO) {
                            deck.add(new Card(color, type));
                        }
                    }
                }
            }
        }

        for(int i = 0; i < 4; i++){
            deck.add(new Card(Color.BLACK, Type.WILD));
            deck.add(new Card(Color.BLACK, Type.DRAW_FOUR_WILD));
        }

        return deck;

    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public void deal(){

        // Shuffle
        Collections.shuffle(this.deck);

        // Deal
        for (int j = 0; j < Game.STARTING_HAND_SIZE; j++) {
            for (int i = 0; i < this.players.size(); i++) {
                this.players.get(i).addCardToHand(this.deck.remove(0));
            }
        }
        // Discard
        this.discardPile = this.deck.remove(0);

    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void currentPlayerMakeMove(){

        //Check if user can place a card

        //Get card from player
        Card c = this.players.get(this.currentPlayer).discardFromHand();

        //Place card onto discard pile
        this.discardPile = c;

        //Specialty card logic
        switch(this.discardPile.getType()){
            case REVERSE:
                this.flipDirection();
                break;
            case SKIP:
                this.moveToNextPlayer();
                break;
        }

        //Move to next player
        this.moveToNextPlayer();
    }

    private void flipDirection(){
        if(this.direction == Direction.CW){
            this.direction = Direction.CCW;
        }
        else {
            this.direction = Direction.CW;
        }
    }

    private void moveToNextPlayer(){
        if (this.direction == Direction.CW){
            if(this.currentPlayer < this.players.size()-1){
                this.currentPlayer++;
            }
            else{
                this.currentPlayer = 0;
            }
        }
        else{
            if(this.currentPlayer != 0){
                this.currentPlayer--;
            }
            else {
                this.currentPlayer = this.players.size()-1;
            }
        }
    }

    @Override
    public String toString() {
        return "Game{" +
                "discardPile=" + discardPile +
                ", currentPlayer=" + currentPlayer +
                ", direction=" + direction +
                ", deck=" + deck +
                ", players=" + players +
                '}';
    }
}
