package vycet;

public class Card {
    Colour colour;
    Value value;

    public Card(){
        this.colour = null;
        this.value = null;
    }

    public Card(Colour c, Value v){
        this.colour = c;
        this.value = v;
    }

    @Override
    public String toString(){
        return "Card [Colour=" + colour + ", Value=" + value + ", NumberValue=" + value.getValue() + "]";
    }

    public static void main(String[] args) {
        Card demo = new Card(Colour.HEARTS, Value.QUEEN);
        System.out.println(demo.toString());
    }
}
