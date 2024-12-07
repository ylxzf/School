package vycet;

public enum Value {
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(15),
    KING(21),
    ACE(42);

    private int i;
    private Value(int i) {
        this.i = i;
    }

    public int getValue(){
        return this.i;
    }
}

