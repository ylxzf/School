package vycet;

public class Card {
    Colour colour;
    Value value;

    public Card(){
        this.colour = null;
        this.value = null;
    }

    public Card(Colour colour, Value value){
        this.colour = colour;
        this.value = value;
    }

    @Override
    public String toString(){
        return "Card [Colour=" + this.colour + ", Value=" + this.value + ", NumberValue=" + this.value.getValue() + "]";
    }

    public static void main(String[] args) {
        Card demo = new Card(Colour.HEARTS, Value.QUEEN);
        System.out.println(demo.toString());
    }
}
