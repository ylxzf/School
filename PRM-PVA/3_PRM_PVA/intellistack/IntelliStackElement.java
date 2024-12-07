package intellistack;

public class IntelliStackElement {

    private int data;
    private IntelliStackElement next;
    public IntelliStackElement(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public IntelliStackElement getNext() {
        return next;
    }

    public void setNext(IntelliStackElement next) {
        this.next = next;
    }
}