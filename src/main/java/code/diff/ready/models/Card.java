package code.diff.ready.models;

import code.diff.ready.enums.Color;
import code.diff.ready.enums.Type;

public class Card {

    private Color color;
    private Type type;

    public Card(Color color, Type type) {
        this.color = color;
        this.type = type;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "{color: " + color + ", type: " + type + '}';
    }
}
